package com.adobe.aem.guides.wknd.core.dto;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultipleItem {

    @ValueMapValue
    private String icon;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String ctaText;

    @ValueMapValue
    private String ctaLink;

    @ValueMapValue
    private String image;

    public String getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCtaText() {
        return ctaText;
    }

    public String getCtaLink() {
        return ctaLink;
    }

    public String getImage() {
        return image;
    }
}