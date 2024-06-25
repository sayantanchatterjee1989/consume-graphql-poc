package com.graphql.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.graphql.entity.ApplicationMaster;
import com.graphql.entity.CompanyMaster;
import com.graphql.entity.CompanyProdGroupMpg;
import com.graphql.entity.ProductApplicationMpg;
import com.graphql.entity.ProductGroupMaster;
import com.graphql.entity.ProductGroupProductMpg;
import com.graphql.entity.ProductMaster;
import com.graphql.model.PullRequestDetails;
import com.graphql.repository.CompanyMasterRepository;
import com.graphql.utility.GitUtility;

@ExtendWith(MockitoExtension.class)
public class ProductGroupServiceImplTest {

	@InjectMocks
	private ProductGroupServiceImpl productGroupService;

	@Mock
	GitUtility gitUtility;

	@Mock
	private CompanyMasterRepository companyMasterRepository;

	@Test
	public void fetchPullRequestDetailsTest() {

		PullRequestDetails response = productGroupService.fetchPullRequestDetails();
		assertThat(response.getCompanyDetails().size(), equalTo(1));
	}

	@BeforeEach
	public void setUp() {

		ApplicationMaster appRes = new ApplicationMaster();
		appRes.setApplicationCode("App1");
		appRes.setApplicationName("Application 1");
		appRes.setRepo_owner("sayantanchatterjee1989");
		appRes.setRepository("TollManagement");
		appRes.setId(1L);
		appRes.setCreatedBy("Sayantan");
		appRes.setCreatedDate(LocalDateTime.now());

		ProductMaster productRes = new ProductMaster();
		productRes.setId(1L);
		productRes.setProductCode("Prod1");
		productRes.setProductName("Product 1");
		productRes.setStatus(1);
		productRes.setCreatedBy("Sayantan");
		productRes.setCreatedDate(LocalDateTime.now());

		ProductApplicationMpg productApplicationMpg = new ProductApplicationMpg();
		productApplicationMpg.setId(1L);
		productApplicationMpg.setStatus(1);
		productApplicationMpg.setApplicationId(appRes);
		productApplicationMpg.setProductId(productRes);
		productApplicationMpg.setCreatedBy("Sayantan");
		productApplicationMpg.setCreatedDate(LocalDateTime.now());

		Set<ProductApplicationMpg> productApplicationMpgSet = new HashSet<>();
		productApplicationMpgSet.add(productApplicationMpg);

		productRes.setmProdAppMpg(productApplicationMpgSet);

		ProductGroupMaster productGroup = new ProductGroupMaster();
		productGroup.setId(1L);
		productGroup.setProductGroupCode("ProdGroup1");
		productGroup.setProductGroupName("Product Group 1");
		productGroup.setStatus(1);
		productGroup.setCreatedBy("Sayantan");
		productGroup.setCreatedDate(LocalDateTime.now());

		ProductGroupProductMpg productGroupProductMpg = new ProductGroupProductMpg();
		productGroupProductMpg.setId(1L);
		productGroupProductMpg.setStatus(1);
		productGroupProductMpg.setProductId(productRes);
		productGroupProductMpg.setProductGroupId(productGroup);
		productGroupProductMpg.setCreatedBy("Sayantan");
		productGroupProductMpg.setCreatedDate(LocalDateTime.now());

		Set<ProductGroupProductMpg> productGroupProductMpgSet = new HashSet<>();
		productGroupProductMpgSet.add(productGroupProductMpg);

		productGroup.setmProdGrpProdMpg(productGroupProductMpgSet);

		CompanyMaster companyMaster = new CompanyMaster();
		companyMaster.setId(1L);
		companyMaster.setStatus(1);
		companyMaster.setCompanyCode("Comp1");
		companyMaster.setCompanyName("Company 1");
		companyMaster.setCreatedBy("Sayantan");
		companyMaster.setCreatedDate(LocalDateTime.now());

		CompanyProdGroupMpg companyProdGroupMpg = new CompanyProdGroupMpg();
		companyProdGroupMpg.setId(1L);
		companyProdGroupMpg.setStatus(1);
		companyProdGroupMpg.setCompanyId(companyMaster);
		companyProdGroupMpg.setProductGroupId(productGroup);
		companyProdGroupMpg.setCreatedBy("Sayantan");
		companyProdGroupMpg.setCreatedDate(LocalDateTime.now());

		Set<CompanyProdGroupMpg> companyProdGroupMpgSet = new HashSet<>();
		companyProdGroupMpgSet.add(companyProdGroupMpg);

		companyMaster.setmCmpProdGrpMpg(companyProdGroupMpgSet);

		List<CompanyMaster> companyMasterList = new ArrayList<>();
		companyMasterList.add(companyMaster);

		Mockito.when(companyMasterRepository.findAll()).thenReturn(companyMasterList);
		Mockito.when(gitUtility.fetchPullRequestDetailsThroughWebClient("sayantanchatterjee1989", "TollManagement"))
				.thenReturn(1);
	}
}
