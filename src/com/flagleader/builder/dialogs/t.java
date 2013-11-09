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

public class t extends f
{
  private Text b;
  private Text c;
  private Text d;
  private Text e;
  StyledText a;

  public t()
  {
    super(new Shell());
  }

  public t(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(ResourceTools.getMessage("title.RequireTrailDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 300, 200, 2);
    a(localComposite2, ResourceTools.getMessage("user.RequireTrailDialog"));
    this.c = b(localComposite2, 2048, 200, 16);
    a(localComposite2, ResourceTools.getMessage("mobile.RequireTrailDialog"));
    this.d = b(localComposite2, 2048, 200, 16);
    a(localComposite2, ResourceTools.getMessage("email.RequireTrailDialog"));
    this.e = b(localComposite2, 2048, 200, 16);
    a(localComposite2, ResourceTools.getMessage("company.RequireTrailDialog"));
    this.b = b(localComposite2, 2048, 200, 16);
    a(localComposite2, ResourceTools.getMessage("require.RequireTrailDialog"));
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
      localHtmlEmail.setFrom(this.e.getText(), this.c.getText());
      localHtmlEmail.setSubject(this.b.getText() + "request rule builder trail.");
      localHtmlEmail.setCharset("UTF-8");
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("user:" + this.c.getText()).append(FileUtil.newline);
      localStringBuffer.append("mobile:" + this.d.getText()).append(FileUtil.newline);
      localStringBuffer.append("company:" + this.b.getText()).append(FileUtil.newline);
      localStringBuffer.append(this.a.getText());
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
 * Qualified Name:     com.flagleader.builder.dialogs.t
 * JD-Core Version:    0.6.0
 */