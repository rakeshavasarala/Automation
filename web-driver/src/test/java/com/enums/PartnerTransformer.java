package com.enums;

import cucumber.api.DataTable;
import cucumber.api.Transformer;


public class PartnerTransformer extends Transformer<DataTable> {


    @Override
    public DataTable transform(final String value) {
        return null;
    }


    public PartnerModel transform(PartnerModel partnerModel) {


        return partnerModel;
    }

}
