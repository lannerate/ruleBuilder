package com.flagleader.builder.dialogs;

import com.flagleader.a.a.r;
import com.flagleader.builder.ResourceTools;
import com.flagleader.util.filesystem.FileUtil;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

public class AboutLicenseDialog1 extends TitleAreaDialog
{
  Link a;
  Label b;

  public AboutLicenseDialog1(Shell paramShell)
  {
    super(paramShell);
  }

  protected void createButtonsForButtonBar(Composite paramComposite)
  {
    ((GridLayout)paramComposite.getLayout()).numColumns += 1;
    Button localButton1 = new Button(paramComposite, 8);
    localButton1.setText(com.flagleader.manager.d.c.b("RequireLicense"));
    localButton1.setFont(JFaceResources.getDialogFont());
    localButton1.addSelectionListener(new c(this));
    setButtonLayoutData(localButton1);
    ((GridLayout)paramComposite.getLayout()).numColumns += 1;
    Button localButton2 = new Button(paramComposite, 8);
    localButton2.setText(com.flagleader.manager.d.c.b("importLicense.text"));
    localButton2.setFont(JFaceResources.getDialogFont());
    localButton2.addSelectionListener(new d(this));
    setButtonLayoutData(localButton2);
    createButton(paramComposite, 0, ResourceTools.getMessage("Ok"), true);
    createButton(paramComposite, 1, ResourceTools.getMessage("Cancel"), false);
  }

  protected GridLayout a(int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    return localGridLayout;
  }

  protected GridData a(int paramInt1, int paramInt2)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt1;
    localGridData.heightHint = paramInt2;
    return localGridData;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(com.flagleader.manager.d.c.a("AboutMessage", new Object[] { com.flagleader.manager.d.c.b(), com.flagleader.manager.d.c.b("builderversion", "3.0.0") }));
    setTitle(com.flagleader.manager.d.c.b("AboutTitle"));
    setTitleImage(ResourceTools.getImage("logo.icon"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 128);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(500, 200));
    Group localGroup = new Group(localComposite2, 128);
    localGroup.setLayout(new GridLayout());
    localGroup.setLayoutData(new GridData(4, 4, true, true));
    localGroup.setText(com.flagleader.manager.d.c.b("License.text"));
    int i = 33554432;
    r.a("ruleengine.rlc");
    try
    {
      this.a = new Link(localGroup, 33554432);
      this.a.setText(r.c() + FileUtil.newline + r.a());
      this.a.setSize(this.a.computeSize(-1, -1));
    }
    catch (SWTError localSWTError)
    {
      this.b = new Label(localGroup, 16777280);
      this.b.setText(r.c() + FileUtil.newline + r.a());
      this.b.setSize(this.b.computeSize(-1, -1));
    }
    return paramComposite;
  }

  public static void main(String[] paramArrayOfString)
  {
    Shell localShell = new Shell();
    AboutLicenseDialog1 localAboutLicenseDialog1 = new AboutLicenseDialog1(localShell);
    localAboutLicenseDialog1.open();
    Display localDisplay = localShell.getDisplay();
    while (!localShell.isDisposed())
    {
      if (localDisplay.readAndDispatch())
        continue;
      localDisplay.sleep();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.AboutLicenseDialog1
 * JD-Core Version:    0.6.0
 */