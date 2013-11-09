package com.flagleader.builder;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.manager.a.a.d;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.util.Decrypt;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class WebBuilder
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
    localShell.setText("Visual Rule Solution For Java.");
    localShell.open();
    c.a("web");
    HashMap localHashMap = new HashMap();
    String str1;
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      str1 = paramArrayOfString[i];
      if ((str1 != null) && (str1.indexOf("=") > 0))
        localHashMap.put(str1.substring(0, str1.indexOf("=")), str1.substring(str1.indexOf("=") + 1));
      else
        System.out.println("error param!" + str1);
    }
    FlagLeader localFlagLeader = new FlagLeader();
    Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
    Property.getInstance().setUpdateInternateTime(0L);
    localFlagLeader.setBlockOnOpen(true);
    localFlagLeader.builderManager = new BuilderManager(localFlagLeader);
    localFlagLeader.builderManager.setWebEditor(true);
    localFlagLeader.initWindow();
    localFlagLeader.builderManager.getConfigManager().f(false);
    localFlagLeader.builderManager.getConfigManager().a(true);
    localFlagLeader.builderManager.getConfigManager().b(false);
    localFlagLeader.builderManager.getConfigManager().c(false);
    localFlagLeader.builderManager.getConfigManager().d(false);
    localFlagLeader.builderManager.getConfigManager().e(false);
    FileUtil.setCurrentDir(new File(SystemUtils.USER_HOME, ".visualrules").getPath());
    BuilderConfig.getInstance().setAutosave(false);
    if (localHashMap.get("demoKey") != null)
      BuilderConfig.getInstance().setDemoKey(localHashMap.get("demoKey").toString());
    if (!new File(FileUtil.getCurrentDir(), "rsc").exists())
      new File(FileUtil.getCurrentDir(), "rsc").mkdirs();
    localFlagLeader.builderManager.getConfigManager().c(new File(FileUtil.getCurrentDir(), "rsc").getPath());
    Property.getInstance().setRuleEngineClassDir(new File(FileUtil.getCurrentDir(), "rsc").getPath());
    if (localHashMap.get("driver") != null)
      localFlagLeader.builderManager.getConfigManager().d(localHashMap.get("driver").toString());
    if (localHashMap.get("passwd") != null)
      localFlagLeader.builderManager.getConfigManager().e(ConnectionFactory.decrypt(localHashMap.get("passwd").toString()));
    if (localHashMap.get("url") != null)
      localFlagLeader.builderManager.getConfigManager().g(ConnectionFactory.decrypt(localHashMap.get("url").toString()));
    if (localHashMap.get("uid") != null)
      localFlagLeader.builderManager.getConfigManager().f(ConnectionFactory.decrypt(localHashMap.get("uid").toString()));
    if (localHashMap.get("servlet") != null)
    {
      str1 = Decrypt.decrypt(localHashMap.get("servlet").toString());
      localFlagLeader.builderManager.getConfigManager().v(str1);
      int j = str1.indexOf("/servlet/");
      if (j > 0)
        localFlagLeader.builderManager.getConfigManager().j(str1.substring(0, j + 1));
    }
    RuleEngineFactory.newInstance().getClassLoader().setClassPath(SystemUtils.JAVA_CLASS_PATH);
    try
    {
      RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(FileUtil.getCurrentDir(), "rsc"));
    }
    catch (Exception localException1)
    {
      MessageDialog.openError(localShell, ResourceTools.getMessage("error"), localException1.getMessage());
    }
    if ((localHashMap.get("loginedname") != null) && (localHashMap.get("loginedpasswd") != null) && (!localHashMap.get("loginedpasswd").equals("null")))
      try
      {
        d locald = localFlagLeader.builderManager.getRulesManager().o();
        String str2 = localHashMap.get("loginedname").toString();
        String str3 = ConnectionFactory.decrypt(localHashMap.get("loginedpasswd").toString());
        int k = locald.a(str2, str3);
        if (k > 0)
        {
          localFlagLeader.builderManager.getRulesManager().a(str2, k, locald.d());
          localFlagLeader.builderManager.getRulesManager().a(locald.d());
          localFlagLeader.builderManager.getConfigManager().r(str3);
          localFlagLeader.builderManager.getConfigManager().s(str2);
        }
        else
        {
          MessageDialog.openError(localShell, ResourceTools.getMessage("error.dialog"), locald.i() + localHashMap.get("loginedname"));
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        MessageDialog.openError(localShell, ResourceTools.getMessage("error.dialog"), localException2.getMessage() + localHashMap.get("loginedname"));
        return;
      }
    try
    {
      if (localFlagLeader.builderManager.getUserServer() == null)
        return;
    }
    catch (Exception localException3)
    {
      EngineLogger.getEngineLogger().error(localException3.getMessage(), localException3);
      MessageDialog.openError(localShell, ResourceTools.getMessage("error"), localException3.getMessage() + localHashMap.get("loginedname"));
      localImage.dispose();
      localShell.dispose();
      return;
    }
    if ((localHashMap.get("ruleid") != null) && (localHashMap.get("rulever") != null) && (localFlagLeader.builderManager.getRulesManager().x()))
      localFlagLeader.builderManager.getRulesManager().a(localHashMap.get("ruleid").toString(), localHashMap.get("rulever").toString());
    else
      localFlagLeader.builderManager.openFromServer();
    localImage.dispose();
    localShell.dispose();
    localFlagLeader.open();
    BuilderManager localBuilderManager = localFlagLeader.builderManager;
    localFlagLeader.getShell().addShellListener(new h(localBuilderManager));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.WebBuilder
 * JD-Core Version:    0.6.0
 */