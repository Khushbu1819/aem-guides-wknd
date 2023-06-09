package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

import com.adobe.aem.guides.wknd.core.dto.MultiFieldCollectionItem;

public interface TeaserComponentModel {
    String getText();

    List<MultiFieldCollectionItem> getMultiFieldcollection();

    boolean isEmpty();

}
