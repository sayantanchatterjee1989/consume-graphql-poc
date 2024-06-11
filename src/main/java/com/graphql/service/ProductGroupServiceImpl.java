package com.graphql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.entity.ApplicationMaster;
import com.graphql.entity.CompanyProdGroupMpg;
import com.graphql.entity.CompanyMaster;
import com.graphql.entity.ProductApplicationMpg;
import com.graphql.entity.ProductGroupProductMpg;
import com.graphql.entity.ProductMaster;
import com.graphql.entity.ProductGroupMaster;
import com.graphql.model.Application;
import com.graphql.model.Company;
import com.graphql.model.Product;
import com.graphql.model.ProductGroup;
import com.graphql.model.PullRequestDetails;
import com.graphql.repository.ApplicationMasterRepository;
import com.graphql.repository.CompanyMasterRepository;
import com.graphql.utility.GitUtility;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {

	@Autowired
	ApplicationMasterRepository applicationMasterRepository;

	@Autowired
	GitUtility gitUtility;

	@Autowired
	CompanyMasterRepository companyMasterRepository;

	public PullRequestDetails fetchPullRequestDetails() {
		List<CompanyMaster> companies = companyMasterRepository.findAll();
		PullRequestDetails response = new PullRequestDetails();
		List<Company> companyList = new ArrayList<>();

		for (CompanyMaster company : companies) {
			Company companyRes = new Company();
			companyRes.setCompanyCode(company.getCompanyCode());
			companyRes.setCompanyName(company.getCompanyName());

			List<ProductGroup> productgroups = new ArrayList<>();
			Set<CompanyProdGroupMpg> compProdMpgList = company.getmCmpProdGrpMpg();
			for (CompanyProdGroupMpg compProdMpg : compProdMpgList) {
				ProductGroupMaster productGroup = compProdMpg.getProductGroupId();

				ProductGroup productGroupRes = new ProductGroup();
				productGroupRes.setProductGroupCode(productGroup.getProductGroupCode());
				productGroupRes.setProductGroupName(productGroup.getProductGroupName());

				List<Product> productList = new ArrayList<>();
				Set<ProductGroupProductMpg> prodGrpProdMpgList = productGroup.getmProdGrpProdMpg();
				for (ProductGroupProductMpg prodGrpProdMpg : prodGrpProdMpgList) {
					ProductMaster product = prodGrpProdMpg.getProductId();

					Product productRes = new Product();
					productRes.setProductCode(product.getProductCode());
					productRes.setProductName(product.getProductName());

					List<Application> applicationList = new ArrayList<>();
					Set<ProductApplicationMpg> mProdAppMpgList = product.getmProdAppMpg();
					for (ProductApplicationMpg productApplicationMpg : mProdAppMpgList) {
						ApplicationMaster application = productApplicationMpg.getApplicationId();

						Application appRes = new Application();
						appRes.setApplicationCode(application.getApplicationCode());
						appRes.setApplicationName(application.getApplicationName());
						appRes.setOwner(application.getRepo_owner());
						appRes.setRepository(application.getRepository());
						appRes.setPullrequest(String.valueOf(gitUtility.fetchPullRequestDetailsThroughWebClient(
								application.getRepo_owner(), application.getRepository())));

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
