package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class as
{
  int a;
  boolean b;
  Text c;
  Browser d;
  Shell e;
  String f = ResourceTools.getMessage("Startup.browser");
  static Image g = ImageDescriptor.createFromURL(as.class.getClassLoader().getResource("icons/document.gif")).createImage();

  public as(Shell paramShell)
  {
    c();
    this.e = paramShell;
    this.e.setLayout(new FillLayout());
    this.e.setText(a("window.title"));
    this.e.setImage(g);
    Display localDisplay = paramShell.getDisplay();
    FormLayout localFormLayout = new FormLayout();
    paramShell.setLayout(localFormLayout);
    ToolBar localToolBar = new ToolBar(paramShell, 0);
    ToolItem localToolItem1 = new ToolItem(localToolBar, 8);
    localToolItem1.setText(a("Back.browser"));
    ToolItem localToolItem2 = new ToolItem(localToolBar, 8);
    localToolItem2.setText(a("Forward.browser"));
    ToolItem localToolItem3 = new ToolItem(localToolBar, 8);
    localToolItem3.setText(a("Stop.browser"));
    ToolItem localToolItem4 = new ToolItem(localToolBar, 8);
    localToolItem4.setText(a("Refresh.browser"));
    ToolItem localToolItem5 = new ToolItem(localToolBar, 8);
    localToolItem5.setText(a("Go.browser"));
    this.c = new Text(paramShell, 2048);
    Label localLabel = new Label(paramShell, 0);
    ProgressBar localProgressBar = new ProgressBar(paramShell, 0);
    FormData localFormData = new FormData();
    localFormData.top = new FormAttachment(0, 5);
    localToolBar.setLayoutData(localFormData);
    localFormData = new FormData();
    localFormData.left = new FormAttachment(0, 0);
    localFormData.right = new FormAttachment(100, 0);
    localFormData.top = new FormAttachment(this.c, 5, -1);
    localFormData.bottom = new FormAttachment(localLabel, -5, -1);
    Object localObject;
    try
    {
      this.d = new Browser(paramShell, 0);
      this.d.setLayoutData(localFormData);
    }
    catch (SWTError localSWTError)
    {
      localObject = new Label(paramShell, 16777280);
      ((Label)localObject).setText(a("BrowserNotCreated"));
      ((Label)localObject).setLayoutData(localFormData);
    }
    localFormData = new FormData();
    localFormData.top = new FormAttachment(localToolBar, 0, 128);
    localFormData.left = new FormAttachment(localToolBar, 5, 131072);
    localFormData.right = new FormAttachment(100, -5);
    this.c.setLayoutData(localFormData);
    localFormData = new FormData();
    localFormData.left = new FormAttachment(0, 5);
    localFormData.right = new FormAttachment(localProgressBar, 0, -1);
    localFormData.bottom = new FormAttachment(100, -5);
    localLabel.setLayoutData(localFormData);
    localFormData = new FormData();
    localFormData.right = new FormAttachment(100, -5);
    localFormData.bottom = new FormAttachment(100, -5);
    localProgressBar.setLayoutData(localFormData);
    if (this.d != null)
    {
      localToolItem1.setEnabled(this.d.isBackEnabled());
      localToolItem2.setEnabled(this.d.isForwardEnabled());
      at localat = new at(this, localToolItem1, localToolItem2, localToolItem3, localToolItem4, localToolItem5);
      this.d.addLocationListener(new au(this));
      this.d.addProgressListener(new av(this, localProgressBar, localToolItem1, localToolItem2));
      this.d.addStatusTextListener(new aw(this, localLabel));
      if ((paramShell instanceof Shell))
      {
        localObject = paramShell;
        this.d.addTitleListener(new ax(this, (Shell)localObject));
      }
      localToolItem1.addListener(13, localat);
      localToolItem2.addListener(13, localat);
      localToolItem3.addListener(13, localat);
      localToolItem4.addListener(13, localat);
      localToolItem5.addListener(13, localat);
      this.c.addListener(14, new ay(this));
      a(localDisplay, this.d);
    }
  }

  static String a(String paramString)
  {
    try
    {
      return ResourceTools.getMessage(paramString);
    }
    catch (MissingResourceException localMissingResourceException)
    {
      return paramString;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return "!" + paramString + "!";
  }

  static String a(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      return MessageFormat.format(a(paramString), paramArrayOfObject);
    }
    catch (MissingResourceException localMissingResourceException)
    {
      return paramString;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return "!" + paramString + "!";
  }

  static void a(Display paramDisplay, Browser paramBrowser)
  {
    paramBrowser.addOpenWindowListener(new az(paramDisplay));
    paramBrowser.addVisibilityWindowListener(new aA());
    paramBrowser.addCloseWindowListener(new aB());
  }

  public void a()
  {
  }

  public void b()
  {
    this.c.setFocus();
  }

  void c()
  {
  }

  public void b(String paramString)
  {
    if (paramString != null)
      this.d.setUrl(paramString);
    else
      this.d.setUrl(this.f);
    this.e.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.as
 * JD-Core Version:    0.6.0
 */