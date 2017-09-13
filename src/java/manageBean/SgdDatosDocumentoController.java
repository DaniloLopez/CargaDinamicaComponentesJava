package manageBean;

import entity.SgdDatosDocumento;
import manageBean.util.JsfUtil;
import manageBean.util.JsfUtil.PersistAction;
import sesionBean.SgdDatosDocumentoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("sgdDatosDocumentoController")
@SessionScoped
public class SgdDatosDocumentoController implements Serializable {

    @EJB
    private sesionBean.SgdDatosDocumentoFacade ejbFacade;
    private List<SgdDatosDocumento> items = null;
    private SgdDatosDocumento selected;

    public SgdDatosDocumentoController() {
    }

    public SgdDatosDocumento getSelected() {
        return selected;
    }

    public void setSelected(SgdDatosDocumento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SgdDatosDocumentoFacade getFacade() {
        return ejbFacade;
    }

    public SgdDatosDocumento prepareCreate() {
        selected = new SgdDatosDocumento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SgdDatosDocumentoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SgdDatosDocumentoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SgdDatosDocumentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SgdDatosDocumento> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public SgdDatosDocumento getSgdDatosDocumento(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SgdDatosDocumento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SgdDatosDocumento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SgdDatosDocumento.class)
    public static class SgdDatosDocumentoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SgdDatosDocumentoController controller = (SgdDatosDocumentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sgdDatosDocumentoController");
            return controller.getSgdDatosDocumento(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SgdDatosDocumento) {
                SgdDatosDocumento o = (SgdDatosDocumento) object;
                return getStringKey(o.getIdx());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SgdDatosDocumento.class.getName()});
                return null;
            }
        }

    }

}
