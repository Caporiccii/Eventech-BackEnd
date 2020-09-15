package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.Company;

public interface ICompanyOut {

    Company getForEntity(Long companyId);

    void postForEntity(Company company);

    void deleteForEntity(Long companyId);

    void putForEntity(Long companyId,Company company);

}
