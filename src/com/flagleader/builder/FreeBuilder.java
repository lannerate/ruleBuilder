package com.flagleader.builder;

import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class FreeBuilder
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
    localShell.setText("Visual Rules For Java.");
    localShell.open();
    c.a("test");
    String str = null;
    if (BuilderConfig.getInstance().isLoadDefault())
      str = RuleRepository.DEFAULTEXT;
    if (paramArrayOfString.length > 0)
      str = "";
    for (int i = 0; i < paramArrayOfString.length; i++)
      str = str + paramArrayOfString[i] + " ";
    FlagLeader localFlagLeader = new FlagLeader();
    Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
    Property.getInstance().setUpdateInternateTime(0L);
    localFlagLeader.setBlockOnOpen(true);
    localFlagLeader.builderManager = new BuilderManager(localFlagLeader);
    localFlagLeader.builderManager.getConfigManager().f(false);
    localFlagLeader.builderManager.getConfigManager().a(true);
    localFlagLeader.builderManager.getConfigManager().b(false);
    localFlagLeader.builderManager.getConfigManager().c(false);
    localFlagLeader.builderManager.getConfigManager().d(false);
    localFlagLeader.builderManager.getConfigManager().e(false);
    BuilderConfig.getInstance().setAutosave(false);
    if (!new File(FileUtil.getCurrentDir(), "rsc").exists())
      new File(FileUtil.getCurrentDir(), "rsc").mkdirs();
    localFlagLeader.builderManager.getConfigManager().c(new File(FileUtil.getCurrentDir(), "rsc").getPath());
    Property.getInstance().setRuleEngineClassDir(new File(FileUtil.getCurrentDir(), "rsc").getPath());
    try
    {
      RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(FileUtil.getCurrentDir(), "rsc"));
    }
    catch (Exception localException)
    {
      MessageDialog.openError(localShell, ResourceTools.getMessage("error"), localException.getMessage());
    }
    if ((str != null) && (new File(str).exists()))
      localFlagLeader.builderManager.getRulesManager().a(new File(str));
    localFlagLeader.initWindow();
    localImage.dispose();
    localShell.dispose();
    localFlagLeader.open();
    BuilderManager localBuilderManager = localFlagLeader.builderManager;
    localFlagLeader.getShell().addShellListener(new e(localBuilderManager));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.FreeBuilder
 * JD-Core Version:    0.6.0
 */