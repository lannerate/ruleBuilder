package com.flagleader.builder.dialogs;

import com.flagleader.a.a.r;
import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.d.c;
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

public class AboutLicenseDialog extends TitleAreaDialog
{
  public AboutLicenseDialog(Shell paramShell)
  {
    super(paramShell);
  }

  protected void createButtonsForButtonBar(Composite paramComposite)
  {
    if ((!r.g()) && (!r.h()))
    {
      ((GridLayout)paramComposite.getLayout()).numColumns += 1;
      Button localButton1 = new Button(paramComposite, 8);
      localButton1.setText(c.b("RequireLicense"));
      localButton1.setFont(JFaceResources.getDialogFont());
      localButton1.addSelectionListener(new a(this));
      setButtonLayoutData(localButton1);
      ((GridLayout)paramComposite.getLayout()).numColumns += 1;
      Button localButton2 = new Button(paramComposite, 8);
      localButton2.setText(c.b("RegisterLicense"));
      localButton2.setFont(JFaceResources.getDialogFont());
      localButton2.addSelectionListener(new b(this));
      setButtonLayoutData(localButton2);
    }
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
    setMessage(c.a("AboutMessage", new Object[] { c.b(), c.b("builderversion", "3.0.0") }));
    setTitle(c.b("AboutTitle"));
    setTitleImage(ResourceTools.getImage("logo.icon"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 128);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(500, 200));
    Group localGroup = new Group(localComposite2, 128);
    localGroup.setLayout(new GridLayout());
    localGroup.setLayoutData(new GridData(4, 4, true, true));
    localGroup.setText(c.b("License.text"));
    int i = 33554432;
    try
    {
      Link localLink = new Link(localGroup, i);
      if ((!r.g()) && (!r.h()))
      {
        localLink.setText(c.a("AboutTimeout", new String[] { String.valueOf(r.d()) }));
        localLink.setForeground(h.g);
      }
      else
      {
        localLink.setText(c.a("AboutLicense", new String[] { BuilderConfig.getInstance().getUserName(), BuilderConfig.getInstance().getLicenseKey() }));
      }
      localObject = new Link(localGroup, 33554432);
      ((Link)localObject).setText("    " + c.a("AboutSoftware", new String[] { BuilderConfig.getInstance().getUserName(), BuilderConfig.getInstance().getLicenseKey() }));
    }
    catch (SWTError localSWTError)
    {
      Object localObject = new Label(localGroup, 16777280);
      if ((!r.g()) && (!r.h()))
        ((Label)localObject).setText(c.a("AboutTimeout", new String[] { String.valueOf(r.d()) }));
      else
        ((Label)localObject).setText(c.a("AboutLicense", new String[] { BuilderConfig.getInstance().getUserName(), BuilderConfig.getInstance().getLicenseKey() }));
    }
    return (Control)paramComposite;
  }

  public static void main(String[] paramArrayOfString)
  {
    Shell localShell = new Shell();
    AboutLicenseDialog localAboutLicenseDialog = new AboutLicenseDialog(localShell);
    localAboutLicenseDialog.open();
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
 * Qualified Name:     com.flagleader.builder.dialogs.AboutLicenseDialog
 * JD-Core Version:    0.6.0
 */