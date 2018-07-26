package com.ctrip.xpipe.redis.console.model;

import com.ctrip.xpipe.redis.console.service.DcService;

import java.util.Objects;

/**
 * @author chen.zhu
 * <p>
 * Jun 19, 2018
 */
public class RouteModel {

    private long id;

    private long orgId;

    private String srcProxyIds = "";

    private String dstProxyIds = "";

    private String optionProxyIds = "";

    private String srcDcName = "";

    private String dstDcName = "";

    private String tag = "";

    private boolean active;

    public long getId() {
        return id;
    }

    public RouteModel setId(long id) {
        this.id = id;
        return this;
    }

    public long getOrgId() {
        return orgId;
    }

    public RouteModel setOrgId(long orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getSrcProxyIds() {
        return srcProxyIds;
    }

    public RouteModel setSrcProxyIds(String srcProxyIds) {
        this.srcProxyIds = srcProxyIds;
        return this;
    }

    public String getDstProxyIds() {
        return dstProxyIds;
    }

    public RouteModel setDstProxyIds(String dstProxyIds) {
        this.dstProxyIds = dstProxyIds;
        return this;
    }

    public String getOptionProxyIds() {
        return optionProxyIds;
    }

    public RouteModel setOptionProxyIds(String optionProxyIds) {
        this.optionProxyIds = optionProxyIds;
        return this;
    }

    public String getSrcDcName() {
        return srcDcName;
    }

    public RouteModel setSrcDcName(String srcDcName) {
        this.srcDcName = srcDcName;
        return this;
    }

    public String getDstDcName() {
        return dstDcName;
    }

    public RouteModel setDstDcName(String dstDcName) {
        this.dstDcName = dstDcName;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public RouteModel setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public RouteModel setActive(boolean active) {
        this.active = active;
        return this;
    }

    public static RouteModel fromRouteTbl(RouteTbl routeTbl, DcService dcService) {
        RouteModel model = new RouteModel();
        model.setActive(routeTbl.isActive()).setDstProxyIds(routeTbl.getDstProxyIds())
                .setId(routeTbl.getId()).setSrcProxyIds(routeTbl.getSrcProxyIds());

        model.setSrcDcName(dcService.find(routeTbl.getSrcDcId()).getDcName())
                .setDstDcName(dcService.find(routeTbl.getDstDcId()).getDcName());

        model.setTag(routeTbl.getTag()).setOptionProxyIds(routeTbl.getOptionalProxyIds())
                .setOrgId(routeTbl.getRouteOrgId());
        return model;
    }

    public RouteTbl toRouteTbl(DcService dcService) {
        RouteTbl proto = new RouteTbl();
        proto.setActive(active).setId(id).setOptionalProxyIds(optionProxyIds).setSrcProxyIds(srcProxyIds)
                .setDstProxyIds(dstProxyIds).setTag(tag).setRouteOrgId(orgId);
        proto.setSrcDcId(dcService.find(srcDcName).getId()).setDstDcId(dcService.find(dstDcName).getId());
        return proto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteModel that = (RouteModel) o;
        return id == that.id &&
                orgId == that.orgId &&
                active == that.active &&
                Objects.equals(srcProxyIds, that.srcProxyIds) &&
                Objects.equals(dstProxyIds, that.dstProxyIds) &&
                Objects.equals(optionProxyIds, that.optionProxyIds) &&
                Objects.equals(srcDcName, that.srcDcName) &&
                Objects.equals(dstDcName, that.dstDcName) &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orgId, srcProxyIds, dstProxyIds, optionProxyIds, srcDcName, dstDcName, tag, active);
    }
}