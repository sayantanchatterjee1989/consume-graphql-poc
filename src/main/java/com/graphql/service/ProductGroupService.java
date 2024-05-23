package com.graphql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.entity.MApplication;
import com.graphql.entity.MCmpProdGrpMpg;
import com.graphql.entity.MCompany;
import com.graphql.entity.MProdAppMpg;
import com.graphql.entity.MProdGrpProdMpg;
import com.graphql.entity.MProduct;
import com.graphql.entity.MProductGroup;
import com.graphql.model.PullRequestDetails;
import com.graphql.model.PullRequestDetails.Application;
import com.graphql.model.PullRequestDetails.Company;
import com.graphql.model.PullRequestDetails.Product;
import com.graphql.model.PullRequestDetails.ProductGroup;
import com.graphql.repository.MApplicationRepository;
import com.graphql.repository.MCompanyRepository;
import com.graphql.utility.GitUtility;

@Service
public class ProductGroupService {

	@Autowired
	MApplicationRepository mApplicationRepository;

	@Autowired
	GitUtility gitUtility;

	@Autowired
	MCompanyRepository mCompanyRepository;

	public List<MApplication> fetchApplications() {
		List<MApplication> output = mApplicationRepository.fetchAll();
		return output;
	}

	public Integer fetchPullRequest() {
		return gitUtility.fetchPullRequestDetails("sayantanchatterjee1989", "TollManagement");
	}

	public PullRequestDetails fetchPullRequestDetails() {
		List<MCompany> companies = mCompanyRepository.fetchAll();
		PullRequestDetails response = new PullRequestDetails();
		List<Company> companyList = new ArrayList<>();

		for (MCompany company : companies) {
			Company companyRes = new Company();
			companyRes.setCompanyCode(company.getCompanyCode());
			companyRes.setCompanyName(company.getCompanyName());

			List<ProductGroup> productgroups = new ArrayList<>();
			Set<MCmpProdGrpMpg> compProdMpgList = company.getmCmpProdGrpMpg();
			for (MCmpProdGrpMpg compProdMpg : compProdMpgList) {
				MProductGroup productGroup = compProdMpg.getProductGroupId();

				ProductGroup productGroupRes = new ProductGroup();
				productGroupRes.setProductGroupCode(productGroup.getProductGroupCode());
				productGroupRes.setProductGroupName(productGroup.getProductGroupName());

				List<Product> productList = new ArrayList<>();
				Set<MProdGrpProdMpg> prodGrpProdMpgList = productGroup.getmProdGrpProdMpg();
				for (MProdGrpProdMpg prodGrpProdMpg : prodGrpProdMpgList) {
					MProduct product = prodGrpProdMpg.getProductId();

					Product productRes = new Product();
					productRes.setProductCode(product.getProductCode());
					productRes.setProductName(product.getProductName());

					List<Application> applicationList = new ArrayList<>();
					Set<MProdAppMpg> mProdAppMpgList = product.getmProdAppMpg();
					for (MProdAppMpg mProdAppMpg : mProdAppMpgList) {
						MApplication application = mProdAppMpg.getApplicationId();

						Application appRes = new Application();
						appRes.setApplicationCode(application.getApplicationCode());
						appRes.setApplicationName(application.getApplicationName());
						appRes.setOwner(application.getRepo_owner());
						appRes.setRepository(application.getRepository());
						appRes.setPullrequest(String.valueOf(gitUtility
								.fetchPullRequestDetails(application.getRepo_owner(), application.getRepository())));

						applicationList.add(appRes);
					}

					productRes.setApplications(applicationList);
					productList.add(productRes);
				}

				productGroupRes.setProducts(productList);
				productgroups.add(productGroupRes);
			}

			companyRes.setProductgroups(productgroups);
			companyList.add(companyRes);
		}
		response.setCompanyDetails(companyList);
		return response;
	}
}
