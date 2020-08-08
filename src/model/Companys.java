package model;

import java.util.ArrayList;
import java.util.List;

public class Companys {

    private List<Company> companyList;

    public Companys(){
        companyList = new ArrayList<>();

        Company company1 =  new Company(1,"LA BUANDERIE DE FRANCHIMONT SPRL");
        Company company2 =   new Company(2,"NETTOIE TOUT SPRL");

        companyList.add(company1);
        companyList.add(company2);
    }

    public void addCompany(Company otherCompany){
        companyList.add(otherCompany);
    }

    public List<Company> getCompanyList() {
        return companyList;
    }
}
