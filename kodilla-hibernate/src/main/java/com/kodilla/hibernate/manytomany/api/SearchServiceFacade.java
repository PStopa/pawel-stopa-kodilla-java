package com.kodilla.hibernate.manytomany.api;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceFacade.class);

    public List<Employee> searchEmployee(final String partOfName) throws SearchProcessingException {
        String newPartOfName = "%" + partOfName + "%";
        List<Employee> employeesSearchResult = new ArrayList<>();
        employeesSearchResult.addAll(employeeDao.retrieveEmployeeWhereFirstnameContainExtract(newPartOfName));
        employeesSearchResult.addAll(employeeDao.retrieveEmployeeWhereLastnameContainExtract(newPartOfName));
        if(employeesSearchResult.size() == 0) {
            LOGGER.info(SearchProcessingException.ERR_EMPLOYEE_NOT_FOUND);
            throw new SearchProcessingException(SearchProcessingException.ERR_EMPLOYEE_NOT_FOUND);
        } else {
            return employeesSearchResult;
        }
    }

    public List<Company> searchCompany(final String partOfName) throws SearchProcessingException {
        String newPartOfName = "%" + partOfName + "%";
        List<Company> companySearchResult = companyDao.retrieveCompanyWhereNameContainExtract(newPartOfName);
        if(companySearchResult.size() == 0) {
            LOGGER.info(SearchProcessingException.ERR_COMPANY_NOT_FOUND);
            throw new SearchProcessingException(SearchProcessingException.ERR_COMPANY_NOT_FOUND);
        } else {
            return companySearchResult;
        }
    }
}
