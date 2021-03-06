package eu.pms.warnings.actions;


import eu.pms.common.tools.SessionTraker;
import eu.pms.project.database.PmsCommunitiesVw;
import eu.pms.project.useCases.GetPmsCommunityUseCase;
import eu.pms.project.useCases.GetPmsDonorsUseCase;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewAddPmsWarningAction extends Action
{

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        if (!(SessionTraker.isSessionExist(request)))
            return mapping.findForward("invalidAccess");
//        if (!SessionTraker.checkActionToRole(request, this.getClass().getName()))
//            return mapping.findForward("noPermission");
        List communityList = (List) new GetPmsCommunityUseCase().execute(null, request);
        List dononrList = (List) new GetPmsDonorsUseCase().execute(null, request);
        request.setAttribute("communityList",  communityList!=null && communityList.size()>0&& communityList.get(0) instanceof PmsCommunitiesVw ?communityList:null);
        request.setAttribute("dononrList", dononrList);

        return mapping.findForward("success");
    }
}

