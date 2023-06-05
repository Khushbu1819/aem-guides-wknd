package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.aem.guides.wknd.core.dto.MultipleItem;
import com.adobe.aem.guides.wknd.core.models.MultifieldComponentModel;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { MultifieldComponentModel.class }, resourceType = {
        MultifieldComponentModelImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldComponentModelImpl implements MultifieldComponentModel {
    final Logger LOG = LoggerFactory.getLogger(MultifieldComponentModelImpl.class);
    protected static final String RESOURCE_TYPE = "wknd/components/multifieldcomponent";

    @ValueMapValue
    private String text1;

    @ChildResource
    private List<MultipleItem> multiple;

    @Override
    public List<MultipleItem> getMultiple() {
        return multiple;
    }

    @Override

    public boolean isEmpty() {

        return StringUtils.isBlank((CharSequence) multiple);
    }

}