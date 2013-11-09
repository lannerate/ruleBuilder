package com.flagleader.builder;

import com.flagleader.builder.actions.al;
import com.flagleader.builder.d.a;
import com.flagleader.builder.d.e;
import com.flagleader.builder.dialogs.j;
import com.flagleader.engine.Property;
import com.flagleader.manager.e.x;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.JspUtil;
import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class FlagLeader extends ApplicationWindow
  implements IApplication
{
  private static String a = null;
  private static boolean b = false;
  public BuilderManager builderManager;
  private static Image c = ImageDescriptor.createFromURL(FlagLeader.class.getClassLoader().getResource("icons/builder.gif")).createImage();

  public FlagLeader()
  {
    super(null);
  }

  protected MenuManager createMenuManager()
  {
    MenuManager localMenuManager = new MenuManager("");
    this.builderManager.getMenuAndToolBar().a(localMenuManager);
    return localMenuManager;
  }

  protected ToolBarManager createToolBarManager(int paramInt)
  {
    ToolBarManager localToolBarManager = new ToolBarManager(paramInt);
    this.builderManager.getMenuAndToolBar().a(localToolBarManager);
    return localToolBarManager;
  }

  protected CoolBarManager createCoolBarManager(int paramInt)
  {
    return super.createCoolBarManager(paramInt);
  }

  protected StatusLineManager createStatusLineManager()
  {
    StatusLineManager localStatusLineManager = super.createStatusLineManager();
    return localStatusLineManager;
  }

  protected Control createContents(Composite paramComposite)
  {
    getShell().setText(ResourceTools.getMessage("RuleBuilder"));
    getShell().setImage(c);
    getShell().setMaximized(true);
    return this.builderManager.createContent(paramComposite);
  }

  public boolean close()
  {
    if ((this.builderManager.getRulesManager().d() != null) && (this.builderManager.getRulesManager().d().isModified()))
    {
      j localj = new j(this.builderManager);
      localj.open();
    }
    else
    {
      if (this.builderManager.getRulesManager().d() != null)
        this.builderManager.getRulesManager().d().clearAutoSave();
      int i = x.a().d();
      if ((i > 0) && (!this.builderManager.showConfirm(i + ResourceTools.getMessage("colseFtp.dialog"))))
        return false;
      x.a().c();
      System.exit(0);
    }
    return true;
  }

  public void checkUpdate()
  {
    if (BuilderConfig.getInstance().getUpdateUrl().length() > 0)
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        JspUtil.readUrl(BuilderConfig.getInstance().getUpdateUrl(), localStringBuffer);
      }
      catch (Exception localException)
      {
        Logger.getLogger("flagleader").log(Level.WARNING, localException.getLocalizedMessage());
      }
  }

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
    Init.a();
    String str = null;
    if (BuilderConfig.getInstance().isLoadDefault())
      str = RuleRepository.DEFAULTEXT;
    if (paramArrayOfString.length > 0)
      str = "";
    for (int i = 0; i < paramArrayOfString.length; i++)
      str = str + paramArrayOfString[i] + " ";
    Logger localLogger = Logger.getLogger("ruleengine");
    Object localObject;
    try
    {
      new File(SystemUtils.USER_HOME + File.separator + ".visualrules" + File.separator + "logs").mkdirs();
      FileHandler localFileHandler = new FileHandler(SystemUtils.USER_HOME + File.separator + ".visualrules" + File.separator + "logs" + File.separator + "logfile%u.%g.txt", 0, 10);
      localFileHandler.setFormatter(new com.flagleader.server.c());
      localFileHandler.setLevel(Level.ALL);
      Logger.getLogger("flagleader").addHandler(localFileHandler);
      localLogger.addHandler(localFileHandler);
    }
    catch (Exception localException1)
    {
      if (!b)
      {
        localObject = new ConsoleHandler();
        ((ConsoleHandler)localObject).setFormatter(new com.flagleader.server.c());
        ((ConsoleHandler)localObject).setLevel(Level.ALL);
        Logger.getLogger("flagleader").addHandler((Handler)localObject);
        localLogger.addHandler((Handler)localObject);
      }
    }
    if (!BuilderManager.checkLicense())
    {
      localImage.dispose();
      localShell.dispose();
      return;
    }
    Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
    FlagLeader localFlagLeader = new FlagLeader();
    Property.getInstance().setUpdateInternateTime(0L);
    localFlagLeader.setBlockOnOpen(true);
    localFlagLeader.builderManager = new BuilderManager(localFlagLeader);
    if ((com.flagleader.manager.d.c.a("needLogin", false)) || (BuilderConfig.getInstance().isFirstLogin()))
      try
      {
        localObject = localFlagLeader.builderManager.getUserServer();
        if ((localObject == null) || (((String)localObject).length() == 0) || (localFlagLeader.builderManager.getUserType() == 0) || (localFlagLeader.builderManager.getUserid() == 0))
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
    if ((str != null) && (new File(str).exists()))
      localFlagLeader.builderManager.getRulesManager().a(new File(str));
    localFlagLeader.initWindow();
    if (new File(SystemUtils.JAVA_IO_TMPDIR, "engine.jar").exists())
      new File(SystemUtils.JAVA_IO_TMPDIR, "engine.jar").delete();
    if (new File(SystemUtils.JAVA_IO_TMPDIR, "export.jar").exists())
      new File(SystemUtils.JAVA_IO_TMPDIR, "export.jar").delete();
    if (BuilderConfig.getInstance().isAutosave())
      new com.flagleader.builder.d.c(localFlagLeader.builderManager).b();
    if (BuilderConfig.getInstance().isAutoCheckVersion())
      new a(localFlagLeader.builderManager).b();
    new e().b();
    localImage.dispose();
    localShell.dispose();
    localFlagLeader.open();
    BuilderManager localBuilderManager = localFlagLeader.builderManager;
    localFlagLeader.getShell().addShellListener(new d(localBuilderManager));
  }

  public void initWindow()
  {
    addMenuBar();
    addStatusLine();
    addToolBar(8388672);
  }

  public IRunnableContext getApplication()
  {
    return this;
  }

  public boolean canLoadClass()
  {
    return false;
  }

  public String loadNewClass(String paramString)
  {
    return "";
  }

  public void updateEditor()
  {
  }

  public String getFlowPath()
  {
    return BuilderConfig.getInstance().getTempPath() + File.separator + "flow";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.FlagLeader
 * JD-Core Version:    0.6.0
 */