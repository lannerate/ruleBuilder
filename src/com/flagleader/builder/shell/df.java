package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.builder.widget.s;
import com.flagleader.engine.EngineProject;
import com.flagleader.engine.IRuleContext;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleEngineManager;
import com.flagleader.repository.d.u;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.ListUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.List;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class df
{
  Composite a;
  private RuleEngineFactory h;
  private Tree i;
  private Table j;
  Menu b;
  public static String[] c = { u.a("rulepacklocknone.txt"), u.a("rulepacklocked.txt"), u.a("rulepackigiore.txt"), u.a("rulepackdeleted.txt") };
  protected Control d;
  protected Control e;
  protected Composite f;
  protected ToolBar g;

  public df(Composite paramComposite)
  {
    this.a = paramComposite;
  }

  public File a()
  {
    if (!StringUtil.isEmpty(Property.getInstance().getRuleProjectDir()))
      return new File(Property.getInstance().getRuleProjectDir());
    return new File(FileUtil.getCurrentDir(), "rscdir");
  }

  public void b()
  {
    RuleEngineManager.getInstance().init(a());
    SashForm localSashForm = new SashForm(this.a, 256);
    localSashForm.setLayout(h.a(1));
    localSashForm.setLayoutData(new GridData(1808));
    Composite localComposite1 = new Composite(localSashForm, 2048);
    localComposite1.setBackground(h.d);
    localComposite1.setLayout(h.a(1));
    localComposite1.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder1 = new CTabFolder(localComposite1, 8389504);
    localCTabFolder1.setLayoutData(new GridData(1808));
    CTabItem localCTabItem1 = new CTabItem(localCTabFolder1, 0);
    localCTabItem1.setText(ResourceTools.getMessage("ruleproject.RuleServerTray"));
    localCTabItem1.setControl(a(localCTabFolder1));
    localCTabFolder1.setSelection(localCTabItem1);
    Composite localComposite2 = new Composite(localSashForm, 2048);
    localComposite2.setBackground(h.d);
    localComposite2.setLayout(h.a(1));
    localComposite2.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder2 = new CTabFolder(localComposite2, 8389504);
    localCTabFolder2.setLayoutData(new GridData(1808));
    CTabItem localCTabItem2 = new CTabItem(localCTabFolder2, 0);
    localCTabItem2.setText(ResourceTools.getMessage("rulelocal.RuleServerTray"));
    localCTabItem2.setControl(b(localCTabFolder2));
    localCTabFolder2.setSelection(localCTabItem2);
    localSashForm.setWeights(new int[] { 20, 80 });
  }

  private Composite a(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.i = new s().a(localComposite, 2820);
    this.i.setHeaderVisible(false);
    this.i.setLayoutData(new GridData(1808));
    this.i.addSelectionListener(new dg(this));
    this.i.addMouseListener(new dh(this));
    c();
    return localComposite;
  }

  private void c()
  {
    this.i.removeAll();
    List localList = RuleEngineManager.getInstance().getProjects();
    TreeItem localTreeItem = new TreeItem(this.i, 0);
    localTreeItem.setText(ResourceTools.getMessage("actived.RuleServerTray"));
    for (int k = 0; k < localList.size(); k++)
    {
      localTreeItem = new TreeItem(this.i, 0);
      localTreeItem.setText(localList.get(k).toString());
      if (!((EngineProject)localList.get(k)).isActive())
        continue;
      localTreeItem.setForeground(h.g);
    }
  }

  protected Control a(Composite paramComposite)
  {
    this.e = c(paramComposite);
    this.d = b(paramComposite);
    return paramComposite;
  }

  protected Control b(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite.setLayout(localGridLayout);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setFont(paramComposite.getFont());
    i locali = new i(true, true);
    this.j = locali.a(localComposite, 67618);
    this.j.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("rulecolumns.RuleServerTray");
    String[] arrayOfString2 = ResourceTools.getStringArray("ruletypes.RuleServerTray");
    String[] arrayOfString3 = ResourceTools.getStringArray("rulelengths.RuleServerTray");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int k = 0; k < arrayOfString3.length; k++)
      arrayOfInt[k] = Integer.parseInt(arrayOfString3[k]);
    for (k = 0; k < arrayOfString1.length; k++)
      arrayOfString1[k] = ResourceTools.getMessage(arrayOfString1[k] + ".RuleServerTray");
    locali.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.j.setHeaderVisible(true);
    this.j.setLayoutData(new GridData(1808));
    this.j.addMouseListener(new dn(this));
    a(null);
    return localComposite;
  }

  protected Control c(Composite paramComposite)
  {
    Composite localComposite1 = new Composite(paramComposite, 0);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.numColumns = 2;
    localComposite1.setLayout(localGridLayout);
    localComposite1.setLayoutData(new GridData(4, 16777216, true, false));
    localComposite1.setFont(paramComposite.getFont());
    Composite localComposite2 = new Composite(localComposite1, 0);
    GridData localGridData = new GridData(4, 16777216, true, false);
    localGridData.heightHint = 20;
    localGridLayout = new GridLayout();
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.numColumns = 1;
    localComposite2.setLayout(localGridLayout);
    localComposite2.setLayoutData(localGridData);
    this.g = new ToolBar(localComposite2, 256);
    ToolItem localToolItem = new ToolItem(this.g, 8);
    localToolItem.setImage(ResourceTools.getImage("active.icon"));
    localToolItem.setToolTipText(ResourceTools.getMessage("activepack.RuleServerTray"));
    localToolItem.addSelectionListener(new dp(this));
    localToolItem = new ToolItem(this.g, 8);
    localToolItem.setImage(ResourceTools.getImage("unactive.icon"));
    localToolItem.setToolTipText(ResourceTools.getMessage("unactivepack.RuleServerTray"));
    localToolItem.addSelectionListener(new dq(this));
    this.f = new Composite(localComposite1, 0);
    localGridLayout = new GridLayout();
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.numColumns = 10;
    this.f.setLayout(localGridLayout);
    localGridData = new GridData(131072, 16777216, true, false);
    localGridData.widthHint = 150;
    localGridData.heightHint = 20;
    this.f.setLayoutData(localGridData);
    this.f.setFont(paramComposite.getFont());
    return localComposite1;
  }

  private Composite b(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    a(localComposite);
    return localComposite;
  }

  private void a(TreeItem paramTreeItem)
  {
    if (paramTreeItem != null)
      a(a(paramTreeItem.getText()));
  }

  private RuleEngineFactory a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(ResourceTools.getMessage("actived.RuleServerTray"))))
      return RuleEngineManager.getInstance().getOldFactory();
    return RuleEngineFactory.getInstance(paramString);
  }

  private void a(RuleEngineFactory paramRuleEngineFactory)
  {
    if (paramRuleEngineFactory == null)
      return;
    this.h = paramRuleEngineFactory;
    this.j.removeAll();
    try
    {
      List localList = paramRuleEngineFactory.getAllRuleNames();
      int k = 0;
      do
      {
        TableItem localTableItem = new TableItem(this.j, 0);
        IRuleContext localIRuleContext = paramRuleEngineFactory.getContext((String)localList.get(k));
        localTableItem.setData(localIRuleContext);
        localTableItem.setText(0, String.valueOf(k + 1));
        localTableItem.setText(1, (String)localList.get(k));
        a(localTableItem, localIRuleContext, paramRuleEngineFactory.isLockedPack((String)localList.get(k)));
        k++;
        if (localList == null)
          break;
      }
      while (k < localList.size());
    }
    catch (Exception localException)
    {
      EngineLogger.getEngineLogger().error(localException.getMessage(), localException);
    }
  }

  private String a(int paramInt)
  {
    return c[paramInt];
  }

  private void a(TableItem paramTableItem, IRuleContext paramIRuleContext, int paramInt)
  {
    paramTableItem.setText(2, paramIRuleContext.getDescription());
    paramTableItem.setText(3, paramIRuleContext.getRuleVersion());
    paramTableItem.setText(4, a(paramInt));
    paramTableItem.setText(5, ListUtil.arrayToString(paramIRuleContext.getInputs()));
    paramTableItem.setText(6, ListUtil.arrayToString(paramIRuleContext.getOutputs()));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.df
 * JD-Core Version:    0.6.0
 */