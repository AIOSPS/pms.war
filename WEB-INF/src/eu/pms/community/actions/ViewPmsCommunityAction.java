package eu.pms.community.actions;


import eu.pms.common.tools.SessionTraker;
import eu.pms.community.forms.PmsCommunityForm;
import eu.pms.community.useCases.GetPmsCommunityTypeUseCase;
import eu.pms.community.useCases.GetPmsCommunityUseCase;
import eu.pms.community.useCases.GetPmsGovernateUseCase;
import eu.pms.incident.useCases.PmsIncidentListByCommunityUseCase;
import eu.pms.incident.useCases.PmsIncidentListByProjectUseCase;
import eu.pms.project.database.PmsCommunity;
import eu.pms.project.useCases.GetPmsLocationUseCase;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewPmsCommunityAction extends Action {

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        if (!(SessionTraker.isSessionExist(request)))
            return mapping.findForward("invalidAccess");
//        if (!SessionTraker.checkActionToRole(request, this.getClass().getName()))
//            return mapping.findForward("noPermission");

        String comId = request.getParameter("comId");
        ArrayList inputs = new ArrayList();
        inputs.add(comId);

        List communityTypeList = (List) new GetPmsCommunityTypeUseCase().execute(null, request);
        List governateList = (List) new GetPmsGovernateUseCase().execute(null, request);
        List incidentList = (List) new PmsIncidentListByCommunityUseCase().execute(inputs, request);
        request.setAttribute("communityTypeList", communityTypeList);
        request.setAttribute("governateList", governateList);
        request.setAttribute("incidentList", incidentList);
        List communityList = (List) new GetPmsCommunityUseCase().execute(inputs, request);
        PmsCommunity pmsCommunity = null;
        if (communityList != null && communityList.size() > 0 && communityList.get(0) instanceof PmsCommunity) {
            pmsCommunity = (PmsCommunity) communityList.get(0);

            PmsCommunityForm pmsCommunityForm = (PmsCommunityForm) form;
            fillPmsCommunityData(pmsCommunityForm, pmsCommunity);
        }


        return mapping.findForward("success");
    }

    private void fillPmsCommunityData(PmsCommunityForm pmsCommunityForm, PmsCommunity pmsCommunity) {
        pmsCommunityForm.setComId(pmsCommunity.getComId());
        pmsCommunityForm.setComPcbsCode(pmsCommunity.getComPcbsCode());
        pmsCommunityForm.setComOchaCode(pmsCommunity.getComOchaCode());
        pmsCommunityForm.setComName(pmsCommunity.getComName());
        pmsCommunityForm.setTypeId(pmsCommunity.getTypeId());
        pmsCommunityForm.setComTotalAreaLand(pmsCommunity.getComTotalAreaLand());
        pmsCommunityForm.setComLocationShortDescription(pmsCommunity.getComLocationShortDescription());
        pmsCommunityForm.setComTopology(pmsCommunity.getComTopology());
        pmsCommunityForm.setComResidentsTotal(pmsCommunity.getComResidentsTotal());
        pmsCommunityForm.setComMaleTotal(pmsCommunity.getComMaleTotal());
        pmsCommunityForm.setComFemaleTotal(pmsCommunity.getComFemaleTotal());
        pmsCommunityForm.setComKidsTotal(pmsCommunity.getComKidsTotal());
        pmsCommunityForm.setComSchoolsInfo(pmsCommunity.getComSchoolsInfo());
        pmsCommunityForm.setComHealthSchoolsInfo(pmsCommunity.getComHealthSchoolsInfo());
        pmsCommunityForm.setComReligionCenters(pmsCommunity.getComReligionCenters());
        pmsCommunityForm.setComCemetery(pmsCommunity.getComCemetery());
        pmsCommunityForm.setComWaterNetworkInfo(pmsCommunity.getComWaterNetworkInfo());
        pmsCommunityForm.setComSewerageNetworkInfo(pmsCommunity.getComSewerageNetworkInfo());
        pmsCommunityForm.setComElectricalNetworkInfo(pmsCommunity.getComElectricalNetworkInfo());
        pmsCommunityForm.setComSolidWasteServiceInfo(pmsCommunity.getComSolidWasteServiceInfo());
        pmsCommunityForm.setComRoadNetworkInfo(pmsCommunity.getComRoadNetworkInfo());
        pmsCommunityForm.setComTransportNetworkInfo(pmsCommunity.getComTransportNetworkInfo());
        pmsCommunityForm.setComEcnonomicActivitiesInfo(pmsCommunity.getComEcnonomicActivitiesInfo());
        pmsCommunityForm.setGovId(pmsCommunity.getGovId());
        pmsCommunityForm.setComLatitude(pmsCommunity.getComLatitude());
        pmsCommunityForm.setComLongitude(pmsCommunity.getComLongitude());
        pmsCommunityForm.setComPercentAreaC(pmsCommunity.getComPercentAreaC());
        pmsCommunityForm.setComTouchingBorder(pmsCommunity.getComTouchingBorder());
        pmsCommunityForm.setUsername(pmsCommunity.getUsername());
        pmsCommunityForm.setTimeStamp(pmsCommunity.getTimeStamp());

    }
}

