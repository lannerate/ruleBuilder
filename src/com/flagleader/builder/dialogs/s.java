package com.flagleader.builder.dialogs;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.ResourceTools;
import com.flagleader.util.filesystem.FileUtil;
import org.apache.commons.mail.HtmlEmail;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class s extends f
{
  private String b;
  private Text c;
  private Text d;
  private Text e;
  private Text f;
  StyledText a;

  public s(String paramString)
  {
    super(new Shell());
    this.b = paramString;
  }

  public s(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(ResourceTools.getMessage("title.RequireLicenseDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 300, 200, 2);
    a(localComposite2, ResourceTools.getMessage("user.RequireLicenseDialog"));
    this.d = b(localComposite2, 2048, 200, 16);
    a(localComposite2, ResourceTools.getMessage("mobile.RequireLicenseDialog"));
    this.e = b(localComposite2, 2048, 200, 16);
    a(localComposite2, ResourceTools.getMessage("email.RequireLicenseDialog"));
    this.f = b(localComposite2, 2048, 200, 16);
    a(localComposite2, ResourceTools.getMessage("company.RequireLicenseDialog"));
    this.c = b(localComposite2, 2048, 200, 16);
    a(localComposite2, ResourceTools.getMessage("require.RequireLicenseDialog"));
    this.a = new StyledText(localComposite2, 8391426);
    GridData localGridData = new GridData(200, 64);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.a.setLayoutData(localGridData);
    return localComposite1;
  }

  protected void okPressed()
  {
    try
    {
      HtmlEmail localHtmlEmail = new HtmlEmail();
      localHtmlEmail.setHostName(BuilderConfig.getInstance().getEmailServer());
      localHtmlEmail.addTo("tech@flagleader.com", "VRS");
      localHtmlEmail.setAuthentication(BuilderConfig.getInstance().getEmailUser(), BuilderConfig.getInstance().getEmailPasswd());
      localHtmlEmail.setFrom(this.f.getText(), this.f.getText());
      localHtmlEmail.setSubject(this.c.getText() + "request rule builder license.");
      localHtmlEmail.setCharset("UTF-8");
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("user:" + this.d.getText()).append(FileUtil.newline);
      localStringBuffer.append("mobile:" + this.e.getText()).append(FileUtil.newline);
      localStringBuffer.append("company:" + this.c.getText()).append(FileUtil.newline);
      localStringBuffer.append("checkCode:" + this.b).append(FileUtil.newline);
      localStringBuffer.append(this.a.getText());
      localHtmlEmail.setHtmlMsg(localStringBuffer.toString());
      localHtmlEmail.setMsg(localStringBuffer.toString());
      localHtmlEmail.send();
      super.okPressed();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getMessage());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.s
 * JD-Core Version:    0.6.0
 */