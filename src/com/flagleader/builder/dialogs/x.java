package com.flagleader.builder.dialogs;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.ResourceTools;
import org.apache.commons.mail.HtmlEmail;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class x extends f
{
  private String a = "";
  private String b = "";
  private Text c;
  private Text d;
  private Text e;
  private Text f;
  private Text g;

  public x(String paramString1, String paramString2)
  {
    super(new Shell());
    this.a = paramString1;
    this.b = paramString2;
  }

  public x(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(ResourceTools.getMessage("title.SendMailDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 300, 150, 2);
    a(localComposite2, ResourceTools.getMessage("emailto.SendMailDialog"));
    this.e = b(localComposite2, 2048, 200, 16);
    if (this.b != null)
    {
      this.e.setText(BuilderConfig.getInstance().getEmailTo());
      this.e.selectAll();
    }
    a(localComposite2, ResourceTools.getMessage("emailtoname.SendMailDialog"));
    this.f = b(localComposite2, 2048, 200, 16);
    if (this.b != null)
      this.f.setText(BuilderConfig.getInstance().getEmailToName());
    a(localComposite2, ResourceTools.getMessage("emailtitle.SendMailDialog"));
    this.g = b(localComposite2, 2048, 200, 16);
    if (this.b != null)
      this.g.setText(this.a);
    a(localComposite2, ResourceTools.getMessage("emailfrom.SendMailDialog"));
    this.c = b(localComposite2, 2048, 200, 16);
    if (this.b != null)
      this.c.setText(BuilderConfig.getInstance().getEmailAuthor());
    a(localComposite2, ResourceTools.getMessage("emailfromname.SendMailDialog"));
    this.d = b(localComposite2, 2048, 200, 16);
    if (this.b != null)
      this.d.setText(BuilderConfig.getInstance().getEmailAuthorName());
    return localComposite1;
  }

  protected void okPressed()
  {
    try
    {
      HtmlEmail localHtmlEmail = new HtmlEmail();
      localHtmlEmail.setHostName(BuilderConfig.getInstance().getEmailServer());
      localHtmlEmail.addTo(this.e.getText(), this.f.getText());
      localHtmlEmail.setAuthentication(BuilderConfig.getInstance().getEmailUser(), BuilderConfig.getInstance().getEmailPasswd());
      localHtmlEmail.setFrom(this.c.getText(), this.d.getText());
      localHtmlEmail.setSubject(this.g.getText());
      localHtmlEmail.setCharset("UTF-8");
      localHtmlEmail.setHtmlMsg(this.b);
      localHtmlEmail.setTextMsg("Your email client does not support HTML messages");
      localHtmlEmail.send();
      BuilderConfig.getInstance().setEmailAuthor(this.c.getText());
      BuilderConfig.getInstance().setEmailAuthorName(this.d.getText());
      BuilderConfig.getInstance().setEmailTo(this.e.getText());
      BuilderConfig.getInstance().setEmailToName(this.f.getText());
      BuilderConfig.getInstance().save();
      super.okPressed();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getMessage());
    }
  }

  public static String b(String paramString1, String paramString2)
  {
    x localx = new x(paramString1, paramString2);
    if (localx.open() == 0)
      return localx.a();
    return null;
  }

  public String a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.x
 * JD-Core Version:    0.6.0
 */