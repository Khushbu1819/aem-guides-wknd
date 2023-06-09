package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.adobe.aem.guides.wknd.core.dto.MultiFieldCollectionItem;
import com.adobe.aem.guides.wknd.core.models.TeaserComponentModel;
import com.adobe.cq.wcm.core.components.models.Teaser;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { TeaserComponentModel.class }, resourceType = {
        TeaserComponentImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TeaserComponentImpl implements TeaserComponentModel {

    final Logger LOG = LoggerFactory.getLogger(TeaserComponentImpl.class);

    protected static final String RESOURCE_TYPE = "wknd/components/teasercomponent";

    @Inject
    @SlingObject
    Resource componentResource;

    @ValueMapValue
    private String text;

    @Inject
    @Via("resource")
    private List<MultiFieldCollectionItem> multifieldcollection;

    @PostConstruct
    public void init() {
        multifieldcollection = new ArrayList<>();

        Resource res = componentResource.getChild("multifieldcollection");

        if (null != res && res.hasChildren()) {
            Iterator<Resource> cards = res.listChildren();

            while (cards.hasNext()) {
                Resource card = cards.next();

                MultiFieldCollectionItem teaserData = new MultiFieldCollectionItem();

                teaserData.setTitle(card.getValueMap().get("title", String.class));
                teaserData.setDescription(card.getValueMap().get("description", String.class));
                multifieldcollection.add(teaserData);
                LOG.info(teaserData.toString());
                // LOG.info(teaser.getPretitle());

            }
        }
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<MultiFieldCollectionItem> getMultiFieldcollection() {
        return multifieldcollection;
    }

    @Override

    public boolean isEmpty() {

        return StringUtils.isBlank(text);
    }
}
