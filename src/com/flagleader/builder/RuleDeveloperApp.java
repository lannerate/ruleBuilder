package com.flagleader.builder;

import com.flagleader.builder.d.a;
import com.flagleader.engine.Property;
import com.flagleader.manager.d.b;
import com.flagleader.manager.r;
import com.flagleader.repository.d.v;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.filesystem.FileUtil;
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

public class RuleDeveloperApp
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
    com.flagleader.manager.d.c.a("develop");
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      for (str1 = paramArrayOfString[i]; (i < paramArrayOfString.length - 1) && (paramArrayOfString[(i + 1)].indexOf("=") < 0); str1 = str1 + paramArrayOfString[i])
        i++;
      if ((str1 != null) && (str1.indexOf("=") > 0))
        localHashMap.put(str1.substring(0, str1.indexOf("=")), str1.substring(str1.indexOf("=") + 1));
      else
        System.out.println("error param!" + str1);
    }
    FlagLeader localFlagLeader = new FlagLeader();
    Property.getInstance().setUpdateInternateTime(0L);
    localFlagLeader.setBlockOnOpen(true);
    localFlagLeader.builderManager = new BuilderManager(localFlagLeader);
    localFlagLeader.builderManager.setWebEditor(false);
    String str1 = FileUtil.getCurrentDir() + File.separator + "samples" + File.separator + "default.rep";
    RuleRepository localRuleRepository = new RuleRepository();
    if (new File(str1).exists())
    {
      try
      {
        localRuleRepository = (RuleRepository)new v().load(new File(str1));
        localRuleRepository.clearAllChildren();
      }
      catch (Exception localException1)
      {
        MessageDialog.openError(null, "", localException1.getLocalizedMessage());
      }
      localRuleRepository.setRepFile(new File(str1));
      localFlagLeader.builderManager.getRulesManager().a(localRuleRepository);
      b.a().a(localRuleRepository);
    }
    else
    {
      localFlagLeader.builderManager.getConfigManager().c(false);
      localFlagLeader.builderManager.getConfigManager().d(false);
      localFlagLeader.builderManager.getConfigManager().e(false);
      localFlagLeader.builderManager.getConfigManager().b(false);
      localFlagLeader.builderManager.getConfigManager().c("rules");
      localFlagLeader.builderManager.getConfigManager().v("http://127.0.0.1:8880/servlet/readrule.servlet");
    }
    if ((com.flagleader.manager.d.c.a("needLogin", false)) || (BuilderConfig.getInstance().isFirstLogin()))
    {
      try
      {
        String str2 = localFlagLeader.builderManager.getUserServer();
        if ((str2 == null) || (str2.length() == 0) || (localFlagLeader.builderManager.getUserType() == 0) || (localFlagLeader.builderManager.getUserid() == 0))
        {
          localImage.dispose();
          localShell.dispose();
          return;
        }
      }
      catch (Exception localException2)
      {
        MessageDialog.openError(null, "", ResourceTools.getMessage("loginserver.error") + localException2.getLocalizedMessage());
        localImage.dispose();
        localShell.dispose();
        return;
      }
      m.a().d(2);
      try
      {
        m.a().a(localFlagLeader.builderManager.getAllPackages());
      }
      catch (Exception localException3)
      {
        MessageDialog.openError(localShell, ResourceTools.getMessage("error.dialog"), localException3.getMessage() + localHashMap.get("loginedname"));
        localImage.dispose();
        localShell.dispose();
        return;
      }
      String str3 = localFlagLeader.builderManager.getConfigManager().H();
      int j = str3.indexOf("/servlet/");
      if ((j > 0) && (!str3.substring(0, j + 1).equals(localFlagLeader.builderManager.getConfigManager().p())))
      {
        localFlagLeader.builderManager.getConfigManager().j(str3.substring(0, j + 1));
        localFlagLeader.builderManager.getConfigManager().b();
      }
      if (!new File(str1).exists())
      {
        b.a().a(localRuleRepository);
        localRuleRepository.setRepFile(new File(str1));
        localFlagLeader.builderManager.getRulesManager().a(localRuleRepository);
      }
    }
    if (paramArrayOfString.length > 0)
    {
      str1 = paramArrayOfString[0];
      if (new File(str1).exists())
        localFlagLeader.builderManager.getRulesManager().a(new File(str1));
    }
    else if (new File(str1).exists())
    {
      try
      {
        localRuleRepository.open();
        localFlagLeader.builderManager.getRulesManager().a(localRuleRepository);
      }
      catch (Exception localException4)
      {
        MessageDialog.openError(null, "", localException4.getLocalizedMessage());
      }
    }
    localFlagLeader.initWindow();
    localImage.dispose();
    localShell.dispose();
    if (BuilderConfig.getInstance().isAutosave())
      new com.flagleader.builder.d.c(localFlagLeader.builderManager).b();
    if (BuilderConfig.getInstance().isAutoCheckVersion())
      new a(localFlagLeader.builderManager).b();
    localFlagLeader.open();
    BuilderManager localBuilderManager = localFlagLeader.builderManager;
    localFlagLeader.getShell().addShellListener(new f(localBuilderManager));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.RuleDeveloperApp
 * JD-Core Version:    0.6.0
 */