package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

import com.adobe.aem.guides.wknd.core.dto.MultiFieldCollectionItem;

import com.adobe.cq.wcm.core.components.models.Teaser; 

public interface TeaserComponentModel extends Teaser {
    String getText();

    String getTitle();

    List<MultiFieldCollectionItem> getMultiFieldcollection();

}
