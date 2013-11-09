package com.flagleader.repository.tree;

import com.flagleader.export.PagesMessages;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.export.AbstractPage;
import com.flagleader.repository.export.IPage;

public class ExportModel extends AbstractPage
  implements IPage
{
  public static final String NAME = "ExportModel";
  public static final String DISPLAYNAME = "test.rsp";
  public static final NodeInfo nodeInfo = new NodeInfo("ExportModel", "test.rsp", "test.rsp");
  public static final String DESIGN_PRE = "d_";
  public static final String ACTION_PRE = "a_";
  public static final String PROPERTY_PRE = "p_";
  public static final String HEML_PRE = "h_";
  public static final String STRUTS_PRE = "s_";
  public static final String FORM_PRE = "f_";
  public PagesMessages preferences = null;
  private String value = "";
  private int roleJudge = 0;
  private int excuteRule = 0;
  private int showNavigate = 0;
  private int showInput = 0;
  private int showOutput = 0;
  private int showSuccess = 0;
  private int showError = 0;

  public ExportModel(ExportModel paramExportModel)
  {
    super(paramExportModel);
    this.value = paramExportModel.value;
    this.roleJudge = paramExportModel.roleJudge;
    this.excuteRule = paramExportModel.excuteRule;
    this.showNavigate = paramExportModel.showNavigate;
    this.showInput = paramExportModel.showInput;
    this.showOutput = paramExportModel.showOutput;
    this.showSuccess = paramExportModel.showSuccess;
    this.showError = paramExportModel.showError;
  }

  public ExportModel()
  {
  }

  public ExportModel(String paramString)
  {
    super(paramString);
  }

  public PagesMessages getPreferences()
  {
    if ((this.preferences == null) || (!this.preferences.getPageName().equals(d())))
      this.preferences = new PagesMessages(d(), "pages");
    return this.preferences;
  }

  public String getName()
  {
    return "ExportModel";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExportModel(this);
  }

  public IElement deepClone()
  {
    return new ExportModel(this);
  }

  public int getExcuteRule()
  {
    return this.excuteRule;
  }

  public void setExcuteRule(int paramInt)
  {
    if (getPropertyValue("rule").length() == 0)
      if (paramInt == 1)
        setPropertyValue("rule", "run");
      else if (paramInt == 2)
        setPropertyValue("rule", "notrun");
      else if (paramInt == 3)
        setPropertyValue("rule", "multipage");
    this.excuteRule = paramInt;
  }

  public int getRoleJudge()
  {
    return this.roleJudge;
  }

  public void setRoleJudge(int paramInt)
  {
    if (getPropertyValue("judge").length() == 0)
      if (paramInt == 0)
        setPropertyValue("judge", "notsupport");
      else if (paramInt == 1)
        setPropertyValue("judge", "support");
    this.roleJudge = paramInt;
  }

  public int getShowError()
  {
    return this.showError;
  }

  public void setShowError(int paramInt)
  {
    if (getPropertyValue("error").length() == 0)
      if (paramInt == 0)
        setPropertyValue("error", "errorshow");
      else if (paramInt == 1)
        setPropertyValue("error", "notshow");
    this.showError = paramInt;
  }

  public int getShowInput()
  {
    return this.showInput;
  }

  public void setShowInput(int paramInt)
  {
    if (getPropertyValue("input").length() == 0)
      if (paramInt == 3)
        setPropertyValue("input", "errorshow");
      else if (paramInt == 4)
        setPropertyValue("input", "notshow");
      else
        setPropertyValue("input", "show");
    if (getPropertyValue("submit").length() == 0)
      setPropertyValue("submit", "submit");
    this.showInput = paramInt;
  }

  public int getShowOutput()
  {
    return this.showOutput;
  }

  public void setShowOutput(int paramInt)
  {
    if (getPropertyValue("output").length() == 0)
      if (this.showInput == 2)
        setPropertyValue("output", "notshow");
      else if (this.showInput == 3)
        setPropertyValue("output", "multipage");
      else if (this.showInput == 0)
        setPropertyValue("output", "noerrorshow");
      else
        setPropertyValue("output", "show");
    this.showOutput = paramInt;
  }

  public int getShowSuccess()
  {
    return this.showSuccess;
  }

  public void setShowSuccess(int paramInt)
  {
    if (getPropertyValue("success").length() == 0)
      if (paramInt == 1)
        setPropertyValue("success", "noterrorshow");
      else if (paramInt == 2)
        setPropertyValue("success", "notshow");
    this.showSuccess = paramInt;
  }

  public int getShowNavigate()
  {
    return this.showNavigate;
  }

  public void setShowNavigate(int paramInt)
  {
    if (getPropertyValue("navigate").length() == 0)
      if (paramInt == 0)
        setPropertyValue("navigate", "show");
      else if (paramInt == 1)
        setPropertyValue("navigate", "notshow");
    this.showNavigate = paramInt;
  }

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ExportModel
 * JD-Core Version:    0.6.0
 */