package com.flagleader.builder.dialogs;

import com.flagleader.a.a.r;
import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.BuilderManager;
import java.io.File;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class l extends f
{
  protected Text a;
  protected Text b;
  protected Text c;
  BuilderManager d;

  public l(BuilderManager paramBuilderManager)
  {
    super(Display.getCurrent().getActiveShell());
    this.d = paramBuilderManager;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(b("title.LicenseDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(240, 80));
    a(localComposite2, "userName.LicenseDialog").setLayoutData(b(60));
    this.a = a(localComposite2, 2048);
    this.a.setLayoutData(b(160));
    this.a.setText(BuilderConfig.getInstance().getUserName());
    a(localComposite2, "check.LicenseDialog").setLayoutData(b(60));
    this.b = a(localComposite2, 2056);
    this.b.setLayoutData(b(160));
    this.b.setText(r.a(new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "cpuid.dll")));
    a(localComposite2, "key.LicenseDialog").setLayoutData(b(60));
    this.c = a(localComposite2, 67584);
    this.c.setLayoutData(b(160));
    this.c.setText(BuilderConfig.getInstance().getLicenseKey());
    return localComposite1;
  }

  protected void okPressed()
  {
    BuilderConfig.getInstance().setUserName(this.a.getText());
    BuilderConfig.getInstance().setLicenseKey(this.c.getText());
    MessageDialog.openInformation(null, "", b("info.LicenseDialog"));
    if ((this.d != null) && (this.d.isMainApplication()))
      BuilderConfig.getInstance().save();
    super.okPressed();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.l
 * JD-Core Version:    0.6.0
 */