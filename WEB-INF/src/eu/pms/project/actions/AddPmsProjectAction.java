package eu.pms.project.actions;


import eu.pms.project.forms.PmsProjectForm;
import eu.pms.project.useCases.AddPmsProjectUseCase;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;

public class AddPmsProjectAction extends Action {

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        PmsProjectForm pmsProjectForm = (PmsProjectForm) form;
        String proId = pmsProjectForm.getProId();
        String proTitle = pmsProjectForm.getProTitle();
        String proDescription = pmsProjectForm.getProDescription();
        String proStatus = pmsProjectForm.getProStatus();
        java.math.BigDecimal proBudget = pmsProjectForm.getProBudget();
        String proStartDate = pmsProjectForm.getProStartDate();
        String proEndDate = pmsProjectForm.getProEndDate();
        String proNeedPermit = pmsProjectForm.getProNeedPermit();
        String proHasCluster = pmsProjectForm.getProHasCluster();
        String proNotes = pmsProjectForm.getProNotes();
        String proArea = pmsProjectForm.getProArea();
        String username = "";
        String timeStamp = "";
        String prgId = pmsProjectForm.getPrgId();
        String devId = pmsProjectForm.getDevId();
        String cluId = pmsProjectForm.getCluId();
        String proType = pmsProjectForm.getProType();
        String preId = pmsProjectForm.getPreId();

        String[] donorProjectList = pmsProjectForm.getDonorProjectList();
        String[] implementerProjectList = pmsProjectForm.getImplementerProjectList();
        String[] locationProjectList = pmsProjectForm.getLocationProjectList();
        String[] communityProjectList = pmsProjectForm.getCommunityProjectList();
        String[] benificiaryProjectList = pmsProjectForm.getBenificiaryProjectList();
        String[] indicatorProjectList = pmsProjectForm.getIndicatorProjectList();

        ArrayList inputs = new ArrayList();
        inputs.add(proId);
        inputs.add(proTitle);
        inputs.add(proDescription);
        inputs.add(proStatus);
        inputs.add(proBudget);
        inputs.add(proStartDate);
        inputs.add(proEndDate);
        inputs.add(proNeedPermit);
        inputs.add(proHasCluster);
        inputs.add(proNotes);
        inputs.add(proArea);
        inputs.add(prgId);
        inputs.add(devId);
        inputs.add(cluId);
        inputs.add(proType);
        inputs.add(preId);
        inputs.add(donorProjectList);
        inputs.add(implementerProjectList);
        inputs.add(locationProjectList);
        inputs.add(communityProjectList);
        inputs.add(benificiaryProjectList);
        inputs.add(indicatorProjectList);

        Collection result = new AddPmsProjectUseCase().execute(inputs, request);
        if (result != null && result.size() > 0) {

        }

        return mapping.findForward("success");
    }
}
