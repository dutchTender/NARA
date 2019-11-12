package gov.nara.um.service.impl;

import gov.nara.common.persistence.service.AbstractService;
import gov.nara.um.persistence.dao.iBusinessUnitDao;
import gov.nara.um.persistence.model.BusinessUnit;
import gov.nara.um.service.IBusinessUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BusinessUnitServiceImpl extends AbstractService<BusinessUnit> implements IBusinessUnitService {

    @Autowired
    private iBusinessUnitDao dao;

    public BusinessUnitServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    @Transactional(readOnly = true)
    public BusinessUnit findByName(final String name) {
        return dao.findByName(name);
    }

    // other

    // Spring

    @Override
    protected final iBusinessUnitDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<BusinessUnit> getSpecificationExecutor() {
        return dao;
    }
}
