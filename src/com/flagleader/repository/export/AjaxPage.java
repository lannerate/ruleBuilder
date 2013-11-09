package com.flagleader.repository.export;

import com.flagleader.export.PagesMessages;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.tree.NodeInfo;

public class AjaxPage extends AbstractPage
  implements IPage
{
  public static final String NAME = "AjaxPage";
  public static final String DISPLAYNAME = "json.jsp";
  private String prefreName = "ajax";
  public static final NodeInfo nodeInfo = new NodeInfo("AjaxPage", "json.jsp", "json.jsp");
  public PagesMessages preferences = null;

  public AjaxPage(AjaxPage paramAjaxPage)
  {
    super(paramAjaxPage);
  }

  public PagesMessages getPreferences()
  {
    if ((this.preferences == null) || (!this.preferences.getPageName().equals(d())))
      this.preferences = new PagesMessages(d(), this.prefreName);
    return this.preferences;
  }

  public AjaxPage()
  {
    this.a = "json/xml_request.rsp";
  }

  public AjaxPage(String paramString)
  {
    super(paramString);
    this.a = "json/xml_request.rsp";
  }

  public String getName()
  {
    return "AjaxPage";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitAjaxPage(this);
  }

  public IElement deepClone()
  {
    return new AjaxPage(this);
  }

  public String getPrefreName()
  {
    return this.prefreName;
  }

  public void setPrefreName(String paramString)
  {
    this.prefreName = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.AjaxPage
 * JD-Core Version:    0.6.0
 */