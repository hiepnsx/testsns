package jp.verve.testsns.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.verve.testsns.form.LoginForm;
import jp.verve.testsns.utils.Constants;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class LoginAction extends Action {
  protected Log log = LogFactory.getLog(Constants.PACKAGE);

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    LoginForm loginForm = (LoginForm) form;

    log.info("LOG_DEBUG:" + loginForm.getUserName());

    if (loginForm.getUserName() == null || loginForm.getPassword() == null
        || !loginForm.getUserName().equalsIgnoreCase("test")
        || !loginForm.getPassword().equals("test")) {

      return mapping.findForward("failure");
    } else {
      return mapping.findForward("success");
    }

  }
  /**
   * <p>
   * Helper method to fetch a String property from a DynaActionForm.
   * </p>
   * <p>
   * Values are returned trimmed of leading and trailing whitespace.
   * Zero-length strings are returned as null.
   * </p>
   *
   * @param form     Our DynaActionForm
   * @param property The name of the property
   * @return The value or null if an error occurs
   */
  protected String doGet(ActionForm form, String property) {
    String initial;
    try {
      initial = (String) PropertyUtils.getSimpleProperty(form, property);
    } catch (Throwable t) {
      initial = null;
    }
    String value = null;
    if ((initial != null) && (initial.length() > 0)) {
      value = initial.trim();
      if (value.length() == 0) {
        value = null;
      }
    }
    return value;
  }

}
