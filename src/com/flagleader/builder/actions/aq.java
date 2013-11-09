package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.E;
import com.flagleader.builder.widget.a.af;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.engine.IRuleLog;
import com.flagleader.engine.Property;
import com.flagleader.manager.b.a;
import com.flagleader.manager.e.y;
import com.flagleader.manager.e.z;
import com.flagleader.manager.n;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.rlm.editen.IEditen;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class aq
  implements a, com.flagleader.manager.b.b, com.flagleader.manager.b.c, y
{
  private StyledText a;
  private StyledText b;
  private StyledText c;
  private StyledText d;
  private Table e;
  private Table f;
  private Table g;
  private HashMap h = new HashMap();
  private Tree i;
  private com.flagleader.builder.widget.e j;
  private E k;
  private Hashtable l = new Hashtable();
  private Menu m = null;
  private BuilderManager n;
  private Hashtable o = new Hashtable();
  private CTabFolder p;
  private static final Color q = new Color(null, 255, 0, 0);
  private static final Color r = new Color(null, 0, 0, 255);
  private static final Color s = new Color(null, 200, 200, 0);
  private static final Color t = new Color(null, 0, 128, 0);
  private static final Color u = new Color(null, 0, 0, 0);

  public aq(BuilderManager paramBuilderManager)
  {
    this.n = paramBuilderManager;
  }

  public boolean a(String paramString)
  {
    String[] arrayOfString = ResourceTools.getConfigArray("message.editor");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      if (arrayOfString[i1].equalsIgnoreCase(paramString))
        return true;
    return false;
  }

  public void a(CTabFolder paramCTabFolder)
  {
    this.p = paramCTabFolder;
    Composite localComposite;
    CTabItem localCTabItem;
    if (a("hint"))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      this.e = a(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("info.content"));
      localCTabItem.setControl(localComposite);
    }
    if (a("check"))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      this.i = b(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("check.content"));
      localCTabItem.setControl(localComposite);
    }
    if (a("search"))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      this.f = a(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("search.content"));
      localCTabItem.setControl(localComposite);
    }
    if (a("message"))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      e(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("message.content"));
      localCTabItem.setControl(localComposite);
    }
    if (a("thread"))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      d(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("thread.content"));
      localCTabItem.setControl(localComposite);
    }
    if (a("search"))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      this.g = i(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("copytable.content"));
      localCTabItem.setControl(localComposite);
    }
    if ((a("tomcat")) && (h() != null))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      f(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("tomcat.log"));
      localCTabItem.setControl(localComposite);
    }
    if (a("editor"))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      g(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("application.log"));
      localCTabItem.setControl(localComposite);
    }
    if (a("log"))
    {
      localComposite = new Composite(paramCTabFolder, 0);
      h(localComposite);
      localCTabItem = new CTabItem(paramCTabFolder, 0);
      localCTabItem.setText(ResourceTools.getMessage("engine.log"));
      localCTabItem.setControl(localComposite);
    }
    paramCTabFolder.addSelectionListener(new ar(this, paramCTabFolder));
    this.n.getRulesManager().m().a(this);
    this.n.getRulesManager().m().a(this);
    this.n.getRulesManager().m().a(this);
    this.n.getRulesManager().l().a(this);
  }

  private File h()
  {
    Object localObject = null;
    if (new File(this.n.getConfigManager().a, "tomcat/logs/stdout.log").exists())
      return new File(this.n.getConfigManager().a, "tomcat/logs/stdout.log");
    if (new File(this.n.getConfigManager().a, "tomcat/logs/").exists())
    {
      File localFile = new File(this.n.getConfigManager().a, "tomcat/logs/");
      if (localFile.isDirectory())
      {
        File[] arrayOfFile = localFile.listFiles(new ay(this));
        long l1 = 0L;
        for (int i1 = 0; i1 < arrayOfFile.length; i1++)
        {
          if (arrayOfFile[i1].lastModified() <= l1)
            continue;
          l1 = arrayOfFile[i1].lastModified();
          localObject = arrayOfFile[i1];
        }
      }
    }
    return localObject;
  }

  public StyledText a()
  {
    return this.a;
  }

  public Table b()
  {
    return this.e;
  }

  private Table a(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    Table localTable = new Table(paramComposite, 66306);
    a(localTable);
    return localTable;
  }

  private Tree b(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    Tree localTree = new s().a(paramComposite, 66306);
    localTree.setLayoutData(new GridData(1808));
    a(localTree);
    return localTree;
  }

  private Tree c(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    this.j = new com.flagleader.builder.widget.e();
    Tree localTree = this.j.a(paramComposite, 66306);
    return localTree;
  }

  private Table d(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    this.k = new E();
    Table localTable = this.k.a(paramComposite, 66306);
    return localTable;
  }

  private void a(Tree paramTree)
  {
    paramTree.setLayoutData(new GridData(1808));
    paramTree.addMouseMoveListener(new az(this, paramTree));
    paramTree.addMouseListener(new aA(this, paramTree));
    paramTree.setHeaderVisible(true);
    paramTree.setLinesVisible(true);
    TreeColumn localTreeColumn = new TreeColumn(paramTree, 0);
    localTreeColumn.setText(ResourceTools.getMessage("errorInfo"));
    localTreeColumn.setWidth(450);
    localTreeColumn = new TreeColumn(paramTree, 0);
    localTreeColumn.setText(ResourceTools.getMessage("ErrorResource"));
    localTreeColumn.setWidth(320);
  }

  private void a(Table paramTable)
  {
    paramTable.setLayoutData(new GridData(1808));
    paramTable.addMouseMoveListener(new aE(this, paramTable));
    paramTable.addMouseListener(new aF(this, paramTable));
    paramTable.setHeaderVisible(true);
    paramTable.setLinesVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(ResourceTools.getMessage("errorInfo"));
    localTableColumn.setWidth(300);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(ResourceTools.getMessage("ErrorResource"));
    localTableColumn.setWidth(200);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(ResourceTools.getMessage("errorLocation"));
    localTableColumn.setWidth(300);
  }

  private Composite e(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    this.a = new af(this.n, paramComposite, 8389384).m();
    this.a.addLineStyleListener(new aM(this, null));
    this.a.addMouseMoveListener(new aJ(this));
    this.a.addMouseListener(new aK(this));
    return paramComposite;
  }

  private Composite f(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    this.b = new af(this.n, paramComposite, 8389384).m();
    return paramComposite;
  }

  private Composite g(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    this.c = new af(this.n, paramComposite, 8389384).m();
    return paramComposite;
  }

  private Composite h(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    this.d = new af(this.n, paramComposite, 8389384).m();
    return paramComposite;
  }

  public void a(List paramList, boolean paramBoolean)
  {
    this.e.getDisplay().asyncExec(new aL(this, paramBoolean, paramList));
  }

  public TreeItem a(IRulePackage paramIRulePackage)
  {
    TreeItem[] arrayOfTreeItem = this.i.getItems();
    for (int i1 = 0; i1 < arrayOfTreeItem.length; i1++)
      if (paramIRulePackage.equals(arrayOfTreeItem[i1].getData()))
        return arrayOfTreeItem[i1];
    return null;
  }

  public synchronized void b(IRulePackage paramIRulePackage)
  {
    this.p.getDisplay().asyncExec(new as(this, paramIRulePackage));
  }

  public synchronized void c(IRulePackage paramIRulePackage)
  {
    this.p.getDisplay().asyncExec(new at(this, paramIRulePackage));
  }

  private void d(IRulePackage paramIRulePackage)
  {
    this.i.removeAll();
    if (paramIRulePackage.hasError())
    {
      TreeItem localTreeItem = new TreeItem(this.i, 0);
      localTreeItem.setText(new String[] { paramIRulePackage.getDisplayName(), paramIRulePackage.getExeRulePackageName() });
      localTreeItem.setData(paramIRulePackage);
      a(localTreeItem, paramIRulePackage);
    }
  }

  private void a(TreeItem paramTreeItem, IRulePackage paramIRulePackage)
  {
    paramTreeItem.removeAll();
    List localList = paramIRulePackage.getErrorList();
    if ((localList != null) && (localList.size() > 0))
    {
      for (int i1 = 0; (i1 < localList.size()) && (i1 < 100); i1++)
      {
        TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
        localTreeItem.setText(new String[] { ((com.flagleader.repository.e)localList.get(i1)).a(), ((com.flagleader.repository.e)localList.get(i1)).b() });
        if ((((com.flagleader.repository.e)localList.get(i1)).d() == 1) || (((com.flagleader.repository.e)localList.get(i1)).d() == 0))
          localTreeItem.setForeground(0, h.g);
        else if (((com.flagleader.repository.e)localList.get(i1)).d() == 2)
          localTreeItem.setForeground(0, h.a);
        else if (((com.flagleader.repository.e)localList.get(i1)).d() == 3)
          localTreeItem.setForeground(0, h.j);
        localTreeItem.setData(((com.flagleader.repository.e)localList.get(i1)).c());
      }
      paramTreeItem.setExpanded(true);
    }
  }

  public void a(IRuleLog paramIRuleLog, IRulePackage paramIRulePackage)
  {
  }

  public void a(z paramz)
  {
    this.k.a(paramz);
    this.p.setSelection(4);
  }

  public void a(List paramList)
  {
    this.f.removeAll();
    if ((paramList == null) || (paramList.size() == 0))
      return;
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      TableItem localTableItem = new TableItem(this.f, 0);
      IElement localIElement = (IElement)paramList.get(i1);
      if ((localIElement instanceof IRuleObject))
      {
        String str = "";
        if ((localIElement instanceof IRuleObject))
        {
          IRuleContainer localIRuleContainer = ((IRuleObject)localIElement).getRoot();
          if (localIRuleContainer != null)
          {
            if (localIRuleContainer.getRuleTree() != null)
              str = localIRuleContainer.getRuleTree().getDisplayName();
            else
              str = localIRuleContainer.getDisplayName();
          }
          else
            str = ((IRuleObject)localIElement).getParent().getDisplayName();
        }
        if (((localIElement instanceof IEditen)) && (((IEditen)localIElement).getParentLine() != null))
          localTableItem.setText(new String[] { localIElement.toString(), str, ((IEditen)localIElement).getParentLine().toString() });
        else
          localTableItem.setText(new String[] { localIElement.getDisplayName(), str, localIElement.toString() });
        if (((IRuleObject)localIElement).getRoot() != null)
          localTableItem.setData(((IRuleObject)localIElement).getRoot().getRuleTree());
        else
          localTableItem.setData(((IRuleObject)localIElement).getParent());
      }
      else if ((localIElement instanceof IBusinessObject))
      {
        if (((IBusinessObject)localIElement).getContainer() == null)
          continue;
        localTableItem.setText(new String[] { localIElement.getDisplayName(), ((IBusinessObject)localIElement).getContainer().getDisplayName(), localIElement.toString() });
        localTableItem.setData(((IBusinessObject)localIElement).getContainer());
      }
      else
      {
        if (!(localIElement instanceof ITreeNode))
          continue;
        localTableItem.setText(new String[] { localIElement.getDisplayName(), ((ITreeNode)localIElement).toString(), localIElement.toString() });
        localTableItem.setData((ITreeNode)localIElement);
      }
    }
    for (i1 = 0; i1 < this.f.getColumnCount(); i1++)
      this.f.getColumns()[i1].pack();
    this.p.setSelection(2);
  }

  public void a(String paramString, Level paramLevel)
  {
    paramString = Property.getInstance().formatTime(new Date()) + " : " + paramString;
    if (paramLevel == Level.WARNING)
      this.l.put(paramString, Level.WARNING);
    else if (paramLevel == Level.INFO)
      this.l.put(paramString, Level.INFO);
    else if (paramLevel == Level.SEVERE)
      this.l.put(paramString, Level.SEVERE);
    else if (paramLevel == Level.CONFIG)
      this.l.put(paramString, Level.CONFIG);
    b(paramString);
  }

  private void b(String paramString)
  {
    this.a.getDisplay().asyncExec(new au(this, paramString));
  }

  public void a(LogRecord paramLogRecord)
  {
    a(paramLogRecord.getMessage(), paramLogRecord.getLevel());
  }

  private void i()
  {
    File localFile = h();
    if ((localFile == null) || (this.b.isDisposed()))
      return;
    try
    {
      this.b.setText(FileUtil.readFromFile(localFile));
      this.b.setSelection(this.b.getText().length());
    }
    catch (Exception localException)
    {
    }
  }

  private void j()
  {
    File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", com.flagleader.manager.d.c.c("editor.file", "systemerr.txt"));
    if ((localFile == null) || (this.c.isDisposed()))
      return;
    try
    {
      this.c.setText(FileUtil.readFromFile(localFile));
      this.c.setSelection(this.c.getText().length());
    }
    catch (Exception localException)
    {
    }
  }

  private void k()
  {
    File localFile = new File("ruleengine.log");
    if ((localFile == null) || (this.d.isDisposed()))
      return;
    try
    {
      this.d.setText(FileUtil.readFromFile(localFile));
      this.d.setSelection(this.d.getText().length());
    }
    catch (Exception localException)
    {
    }
  }

  private Table i(Composite paramComposite)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    Table localTable = new Table(paramComposite, 66306);
    b(localTable);
    return localTable;
  }

  private void b(Table paramTable)
  {
    paramTable.setLayoutData(new GridData(1808));
    paramTable.addMouseListener(new av(this, paramTable));
    paramTable.setHeaderVisible(true);
    paramTable.setLinesVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(ResourceTools.getMessage("copyedElement.info"));
    localTableColumn.setWidth(500);
  }

  public void a(IElement paramIElement)
  {
    this.h.put(paramIElement, new Date());
    c();
  }

  public synchronized void c()
  {
    this.g.removeAll();
    TreeMap localTreeMap = new TreeMap(new ax(this));
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (IElement)localIterator.next();
      localTreeMap.put((Date)this.h.get(localObject), localObject);
    }
    Object localObject = localTreeMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      IElement localIElement = (IElement)localTreeMap.get(((Iterator)localObject).next());
      if (localIElement == null)
        continue;
      TableItem localTableItem = new TableItem(this.g, 0);
      localTableItem.setText(new String[] { localIElement.getShowDisplayName() });
      localTableItem.setData(localIElement);
    }
    this.p.setSelection(5);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aq
 * JD-Core Version:    0.6.0
 */