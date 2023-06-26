package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.wknd.core.models.BannerCarouselModel;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { BannerCarouselModel.class }, resourceType = {
        BannerCarouselModelImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerCarouselModelImpl implements BannerCarouselModel {
    final Logger LOG = LoggerFactory.getLogger(BannerCarouselModelImpl.class);
    protected static final String RESOURCE_TYPE = "wknd/components/bannercarousel";

    private List<String> panelList = new ArrayList<>();

    @SlingObject
    private Resource componentResource;

    @PostConstruct
    public void init() {
        Iterable<Resource> childResources = componentResource.getChildren();
        for (Resource child : childResources) {
            String panelTitle = child.getValueMap().get("cq:panelTitle", String.class);
            panelList.add(panelTitle);
        }
    }

    @Override
    public List<String> getPanelList() {
        return panelList;
    }
}
