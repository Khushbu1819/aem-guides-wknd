package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.aem.guides.wknd.core.models.BannerComponentModel;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { BannerComponentModel.class }, resourceType = {
        BannerComponentModelImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerComponentModelImpl implements BannerComponentModel {
    final Logger LOG = LoggerFactory.getLogger(BannerComponentModelImpl.class);
    protected static final String RESOURCE_TYPE = "wknd/components/bannercomponent";

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String contenttype;

    @ValueMapValue
    private String linktext;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String text;

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContentType() {
        return contenttype;
    }

    @Override
    public String getLinkText() {
        return linktext;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override

    public boolean isEmpty() {

        return StringUtils.isBlank(image) && StringUtils.isBlank(title) && StringUtils.isBlank(contenttype)
                && StringUtils.isBlank(linktext) && StringUtils.isBlank(link);
    }

}