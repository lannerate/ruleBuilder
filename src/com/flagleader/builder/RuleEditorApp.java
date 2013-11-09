package com.flagleader.builder;

import com.flagleader.builder.d.e;
import com.flagleader.engine.Property;
import com.flagleader.manager.d.b;
import com.flagleader.manager.r;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.RuleRepository;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class RuleEditorApp
{
  private static final String a = "RuleBuilder3.0.0";

  public static void main(String[] paramArrayOfString)
  {
    Shell localShell = new Shell(16777216);
    localShell.setLocation(new Point(300, 200));
    localShell.setLayout(new FillLayout());
    Composite localComposite = new Composite(localShell, 0);
    localComposite.setLayout(new FillLayout());
    Label localLabel = new Label(localComposite, 0);
    Image localImage = ImageDescriptor.createFromURL(localShell.getClass().getClassLoader().getResource("icons/start.jpg")).createImage();
    localLabel.setImage(localImage);
    localShell.setSize(400, 300);
    localShell.setText("Visual Rules Solution");
    localShell.open();
    com.flagleader.manager.d.c.a("edit");
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      for (str = paramArrayOfString[i]; (i < paramArrayOfString.length - 1) && (paramArrayOfString[(i + 1)].indexOf("=") < 0); str = str + paramArrayOfString[i])
        i++;
      if ((str != null) && (str.indexOf("=") > 0))
        localHashMap.put(str.substring(0, str.indexOf("=")), str.substring(str.indexOf("=") + 1));
      else
        System.out.println("error param!" + str);
    }
    FlagLeader localFlagLeader = new FlagLeader();
    Property.getInstance().setUpdateInternateTime(0L);
    localFlagLeader.setBlockOnOpen(true);
    localFlagLeader.builderManager = new BuilderManager(localFlagLeader);
    localFlagLeader.builderManager.setWebEditor(false);
    String str = RuleRepository.DEFAULTEXT;
    if (paramArrayOfString.length > 0)
      str = "";
    for (int j = 0; j < paramArrayOfString.length; j++)
      str = str + paramArrayOfString[j] + " ";
    m.a().d(1);
    try
    {
      m.a().a(localFlagLeader.builderManager.getAllPackages());
    }
    catch (Exception localException)
    {
      MessageDialog.openError(localShell, ResourceTools.getMessage("error"), localException.getMessage() + localHashMap.get("loginedname"));
      localImage.dispose();
      localShell.dispose();
      return;
    }
    if (new File(str).exists())
      localFlagLeader.builderManager.getRulesManager().a(new File(str));
    localFlagLeader.initWindow();
    localFlagLeader.builderManager.getConfigManager().c(false);
    localFlagLeader.builderManager.getConfigManager().d(false);
    localFlagLeader.builderManager.getConfigManager().e(false);
    localImage.dispose();
    localShell.dispose();
    if (BuilderConfig.getInstance().isAutosave())
      new com.flagleader.builder.d.c(localFlagLeader.builderManager).b();
    new e().b();
    localFlagLeader.open();
    BuilderManager localBuilderManager = localFlagLeader.builderManager;
    localFlagLeader.getShell().addShellListener(new g(localBuilderManager));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.RuleEditorApp
 * JD-Core Version:    0.6.0
 */