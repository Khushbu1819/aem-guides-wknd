package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

import com.adobe.aem.guides.wknd.core.dto.MultipleItem;

public interface MultifieldComponentModel {

    List<MultipleItem> getMultiple();

    boolean isEmpty();
}
