package com.flagleader.builder.a;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.a.A;
import com.flagleader.builder.a.a.B;
import com.flagleader.builder.a.a.M;
import com.flagleader.builder.a.a.Y;
import com.flagleader.builder.a.a.ai;
import com.flagleader.builder.a.a.ak;
import com.flagleader.builder.a.a.am;
import com.flagleader.builder.a.a.an;
import com.flagleader.builder.a.a.au;
import com.flagleader.builder.a.a.aw;
import com.flagleader.builder.a.a.l;
import com.flagleader.builder.a.a.n;
import com.flagleader.builder.a.b.E;
import com.flagleader.builder.a.b.G;
import com.flagleader.builder.a.b.N;
import com.flagleader.builder.a.b.S;
import com.flagleader.builder.a.b.V;
import com.flagleader.builder.a.b.aB;
import com.flagleader.builder.a.b.aL;
import com.flagleader.builder.a.b.aP;
import com.flagleader.builder.a.b.aR;
import com.flagleader.builder.a.b.aU;
import com.flagleader.builder.a.b.aa;
import com.flagleader.builder.a.b.aj;
import com.flagleader.builder.a.b.as;
import com.flagleader.builder.a.b.av;
import com.flagleader.builder.a.b.az;
import com.flagleader.builder.a.d.C;
import com.flagleader.builder.a.d.P;
import com.flagleader.builder.a.d.W;
import com.flagleader.builder.a.d.aI;
import com.flagleader.builder.a.d.aY;
import com.flagleader.builder.a.d.ar;
import com.flagleader.builder.a.e.q;
import com.flagleader.builder.a.f.aT;
import com.flagleader.builder.a.f.aX;
import com.flagleader.builder.a.f.af;
import com.flagleader.builder.a.f.bK;
import com.flagleader.builder.a.f.bQ;
import com.flagleader.builder.a.f.bb;
import com.flagleader.builder.a.f.bj;
import com.flagleader.builder.a.f.bn;
import com.flagleader.builder.a.f.cE;
import com.flagleader.builder.a.f.cG;
import com.flagleader.builder.a.f.cg;
import com.flagleader.builder.a.f.ck;
import com.flagleader.builder.a.f.da;
import com.flagleader.builder.a.f.dj;
import com.flagleader.builder.a.f.do;
import com.flagleader.builder.actions.bm;
import com.flagleader.builder.c.i;
import com.flagleader.builder.c.x;
import com.flagleader.export.PagesMessages;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.d.b;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.db.ProcedureModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.ViewModel;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.excel.ExcelTableSheetModel;
import com.flagleader.repository.excel.ExcelXYSheetModel;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.CustomFunction;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Observable;
import java.util.Set;
import java.util.Stack;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class bu extends Observable
{
  private CTabFolder a;
  private CTabFolder b;
  private boolean c = false;
  private Hashtable d = new Hashtable();
  private Hashtable e = new Hashtable();
  private BuilderManager f;
  private ArrayList g = new ArrayList();
  private boolean h = false;
  private boolean i = false;
  private Stack j = new Stack();
  private HashMap k = new HashMap();
  private CTabItem l;
  private CTabItem m;
  private CTabItem n;

  public bu(BuilderManager paramBuilderManager)
  {
    this.f = paramBuilderManager;
  }

  public void a(CTabFolder paramCTabFolder)
  {
    this.a = paramCTabFolder;
    this.a.addSelectionListener(new bv(this));
    addObserver(this.f.getMenuAndToolBar());
  }

  public void b(CTabFolder paramCTabFolder)
  {
    this.b = paramCTabFolder;
    this.l = new CTabItem(this.b, 0);
    this.l.setText(ResourceTools.getMessage("Properties.edit"));
    this.m = new CTabItem(this.b, 0);
    this.m.setText(ResourceTools.getMessage("RulesProperties.edit"));
    Composite localComposite = new Composite(this.b, 0);
    localComposite.setBackground(com.flagleader.builder.widget.h.d);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite.setLayout(localGridLayout);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setBackground(com.flagleader.builder.widget.h.d);
    localComposite.setData(new q(null, localComposite, this));
    this.m.setControl(localComposite);
    this.n = new CTabItem(this.b, 0);
    this.n.setText(ResourceTools.getMessage("ObjectProperties.edit"));
    Button localButton = new Button(this.b, 8);
    localButton.setImage(ResourceTools.getImage("update2.icon"));
    localButton.setToolTipText(ResourceTools.getMessage("update.popup", "update"));
    localButton.addSelectionListener(new bw(this));
    this.b.setTopRight(localButton);
    this.b.setSelection(this.l);
  }

  public boolean a()
  {
    return this.g.size() > 1;
  }

  public boolean b()
  {
    return this.j.size() > 0;
  }

  public void c()
  {
    if (this.j.size() > 0)
    {
      this.i = true;
      ITreeNode localITreeNode = (ITreeNode)this.j.pop();
      this.g.add(localITreeNode);
      i().getProjectTree().c(localITreeNode);
      setChanged();
      notifyObservers();
    }
  }

  public void d()
  {
    if (this.g.size() > 1)
    {
      this.h = true;
      this.j.push(this.g.remove(this.g.size() - 1));
      i().getProjectTree().c((ITreeNode)this.g.get(this.g.size() - 1));
      setChanged();
      notifyObservers();
    }
  }

  public IElementViewer e()
  {
    if ((this.a != null) && (this.a.getSelectionIndex() >= 0))
    {
      Control localControl = this.a.getSelection().getControl();
      if ((localControl != null) && (!localControl.isDisposed()))
      {
        Object localObject = localControl.getData();
        if ((localObject != null) && ((localObject instanceof IElementViewer)))
          return (IElementViewer)localObject;
      }
    }
    return null;
  }

  public void a(ITreeNode paramITreeNode)
  {
    if (this.a.getItemCount() > 0)
    {
      int i1 = 0;
      if ((this.k.get(paramITreeNode) != null) && (((Integer)this.k.get(paramITreeNode)).intValue() < this.a.getItemCount()))
        i1 = ((Integer)this.k.get(paramITreeNode)).intValue();
      CTabItem localCTabItem = this.a.getItem(i1);
      if ((localCTabItem != null) && (!localCTabItem.isDisposed()) && (localCTabItem.getData() != null) && (localCTabItem.getData().equals(paramITreeNode)))
      {
        this.a.setSelection(localCTabItem);
        return;
      }
    }
    this.f.getShell().setCursor(this.f.getShell().getDisplay().getSystemCursor(3));
    try
    {
      if ((paramITreeNode instanceof Rule))
        a((Rule)paramITreeNode);
      else if ((paramITreeNode instanceof DecisionRule))
        a((DecisionRule)paramITreeNode);
      else if ((paramITreeNode instanceof RuleMirror))
        a((RuleMirror)paramITreeNode);
      else if ((paramITreeNode instanceof DecisionMultiRule))
        a((DecisionMultiRule)paramITreeNode);
      else if ((paramITreeNode instanceof ExpressionRule))
        a((ExpressionRule)paramITreeNode);
      else if ((paramITreeNode instanceof DecisionRelateRule))
        a((DecisionRelateRule)paramITreeNode);
      else if ((paramITreeNode instanceof Envionment))
        a((Envionment)paramITreeNode);
      else if ((paramITreeNode instanceof IRuleSet))
        a((IRuleSet)paramITreeNode);
      else if ((paramITreeNode instanceof IRuleGroup))
        a((IRuleGroup)paramITreeNode);
      else if ((paramITreeNode instanceof CustomFunction))
        b((CustomFunction)paramITreeNode);
      else if ((paramITreeNode instanceof TestCase))
        a((TestCase)paramITreeNode);
      else if ((paramITreeNode instanceof TestCaseLib))
        a((TestCaseLib)paramITreeNode);
      else if ((paramITreeNode instanceof IPage))
        a((IPage)paramITreeNode);
      else if ((paramITreeNode instanceof TableModel))
        a((TableModel)paramITreeNode);
      else if ((paramITreeNode instanceof SelectTable))
        a((SelectTable)paramITreeNode);
      else if ((paramITreeNode instanceof SheetTable))
        a((SheetTable)paramITreeNode);
      else if ((paramITreeNode instanceof SheetMap))
        a((SheetMap)paramITreeNode);
      else if ((paramITreeNode instanceof EnumTable))
        a((EnumTable)paramITreeNode);
      else if ((paramITreeNode instanceof ProcedureModel))
        a((ProcedureModel)paramITreeNode);
      else if ((paramITreeNode instanceof ViewModel))
        a((ViewModel)paramITreeNode);
      else if ((paramITreeNode instanceof CustomSql))
        a((CustomSql)paramITreeNode);
      else if ((paramITreeNode instanceof DBModel))
        a((DBModel)paramITreeNode);
      else if ((paramITreeNode instanceof BOContainerGroup))
        a((BOContainerGroup)paramITreeNode);
      else if ((paramITreeNode instanceof ExcelBookModel))
        a((ExcelBookModel)paramITreeNode);
      else if ((paramITreeNode instanceof ExcelTableSheetModel))
        a((ExcelTableSheetModel)paramITreeNode);
      else if ((paramITreeNode instanceof ExcelXYSheetModel))
        a((ExcelXYSheetModel)paramITreeNode);
      else if ((paramITreeNode instanceof ExcelSheetModel))
        a((ExcelSheetModel)paramITreeNode);
      else if ((paramITreeNode instanceof XmlNode))
        a((XmlNode)paramITreeNode);
      else if ((paramITreeNode instanceof TreeValueNode))
        a((TreeValueNode)paramITreeNode);
      else if ((paramITreeNode instanceof ClassContainer))
        a((ClassContainer)paramITreeNode);
      else if ((paramITreeNode instanceof InterfaceContainer))
        a((InterfaceContainer)paramITreeNode);
      else if ((paramITreeNode instanceof SoapService))
        a((SoapService)paramITreeNode);
      if (this.a.getItemCount() > 0)
        if ((this.k.get(paramITreeNode) != null) && (((Integer)this.k.get(paramITreeNode)).intValue() < this.a.getItemCount()))
        {
          this.a.setSelection(((Integer)this.k.get(paramITreeNode)).intValue());
        }
        else
        {
          this.a.setSelection(0);
          this.k.put(paramITreeNode, new Integer(0));
        }
      Object localObject1;
      if ((this.a.getSelection() != null) && (this.a.getSelection().getControl() != null) && (!this.a.getSelection().getControl().isDisposed()))
      {
        localObject1 = this.a.getSelection().getControl().getData();
        if ((localObject1 != null) && ((localObject1 instanceof IElementViewer)) && (((IElementViewer)localObject1).needUpdate()))
          ((IElementViewer)localObject1).update();
      }
      else if ((this.a.getItemCount() > 0) && (this.a.getItem(0).getControl() != null) && (!this.a.getItem(0).getControl().isDisposed()))
      {
        localObject1 = this.a.getItem(0).getControl().getData();
        if ((localObject1 != null) && ((localObject1 instanceof IElementViewer)) && (((IElementViewer)localObject1).needUpdate()))
          ((IElementViewer)localObject1).update();
      }
      if ((!this.h) && (!this.i))
      {
        if ((this.g.size() == 0) || (!this.g.get(this.g.size() - 1).equals(paramITreeNode)))
          this.g.add(paramITreeNode);
        this.j.clear();
      }
      this.i = false;
      this.h = false;
    }
    catch (SWTError localSWTError)
    {
      localSWTError.printStackTrace();
      g();
    }
    finally
    {
      this.f.getShell().setCursor(null);
    }
  }

  private Composite j()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setBackground(com.flagleader.builder.widget.h.d);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite.setLayout(localGridLayout);
    localComposite.setLayoutData(new GridData(1808));
    return localComposite;
  }

  private Composite c(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setBackground(com.flagleader.builder.widget.h.d);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite.setLayout(localGridLayout);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setBackground(com.flagleader.builder.widget.h.d);
    return localComposite;
  }

  private CTabItem a(String paramString1, String paramString2, ITreeNode paramITreeNode)
  {
    CTabItem localCTabItem = new CTabItem(this.a, 0);
    localCTabItem.setText(paramString1);
    Composite localComposite = b(paramString2);
    if ((localComposite == null) || (localComposite.isDisposed()))
    {
      localComposite = j();
      b(paramString2, localComposite);
    }
    localCTabItem.setControl(localComposite);
    localCTabItem.setData(paramITreeNode);
    c(paramString2);
    return localCTabItem;
  }

  private void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof Rule))
    {
      CTabItem localCTabItem = a(paramITreeNode.getDisplayName(), paramITreeNode.getEditUuid(), paramITreeNode);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new dj(((Rule)paramITreeNode).getRuleElementToken(), (Composite)localCTabItem.getControl(), this));
    }
  }

  private Composite b(String paramString)
  {
    Composite localComposite = (Composite)this.d.get(paramString);
    return localComposite;
  }

  private void c(String paramString)
  {
    this.e.put(paramString, new Long(System.currentTimeMillis()));
    if (this.e.size() > BuilderConfig.getInstance().getCompositeBuffer())
    {
      bx localbx = new bx(this);
      Display.getCurrent().timerExec(1, localbx);
    }
  }

  public void f()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = "";
    Iterator localIterator = this.e.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = localIterator.next().toString();
      Object localObject2 = this.e.get(str);
      if ((localObject2 == null) || (!(localObject2 instanceof Long)) || (((Long)localObject2).longValue() >= l1) || (d(str)))
        continue;
      l1 = ((Long)localObject2).longValue();
      localObject1 = str;
    }
    this.e.remove(localObject1);
    a((String)localObject1);
  }

  private void b(String paramString, Composite paramComposite)
  {
    this.d.put(paramString, paramComposite);
  }

  public void g()
  {
    Iterator localIterator = this.d.keySet().iterator();
    ArrayList localArrayList = new ArrayList();
    BuilderConfig.getInstance().setCompositeBuffer(BuilderConfig.getInstance().getCompositeBuffer() - 1);
    BuilderConfig.getInstance().save();
    String str;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject == null)
        continue;
      str = (String)localObject;
      if (d(str))
        continue;
      localArrayList.add(str);
    }
    for (int i1 = 0; i1 < localArrayList.size(); i1++)
    {
      str = (String)localArrayList.get(i1);
      Composite localComposite = (Composite)this.d.get(str);
      this.d.remove(str);
      localComposite.dispose();
    }
  }

  public void a(String paramString, Composite paramComposite)
  {
    this.e.remove(paramString);
    a(paramString);
    if ((paramComposite != null) && (!paramComposite.isDisposed()))
      paramComposite.dispose();
  }

  public void a(String paramString)
  {
    Composite localComposite = (Composite)this.d.get(paramString);
    this.d.remove(paramString);
    if ((localComposite == null) || (localComposite.isDisposed()))
      return;
    CTabItem[] arrayOfCTabItem = this.a.getItems();
    for (int i1 = 0; i1 < arrayOfCTabItem.length; i1++)
    {
      if ((arrayOfCTabItem[i1].getControl() == null) || (!arrayOfCTabItem[i1].getControl().equals(localComposite)))
        continue;
      localComposite.dispose();
      arrayOfCTabItem[i1].dispose();
      return;
    }
    if ((this.l != null) && (!this.l.isDisposed()) && (this.l.getControl() != null) && (this.l.getControl().equals(localComposite)))
    {
      localComposite.dispose();
      return;
    }
    if ((localComposite != null) && (!localComposite.isDisposed()))
      localComposite.dispose();
  }

  private boolean d(String paramString)
  {
    Composite localComposite = (Composite)this.d.get(paramString);
    if ((localComposite == null) || (localComposite.isDisposed()))
      return false;
    CTabItem[] arrayOfCTabItem = this.a.getItems();
    for (int i1 = 0; i1 < arrayOfCTabItem.length; i1++)
      if ((arrayOfCTabItem[i1].getControl() != null) && (!arrayOfCTabItem[i1].getControl().isDisposed()) && (arrayOfCTabItem[i1].getControl().equals(localComposite)))
        return true;
    arrayOfCTabItem = this.b.getItems();
    for (i1 = 0; i1 < arrayOfCTabItem.length; i1++)
      if ((arrayOfCTabItem[i1].getControl() != null) && (!arrayOfCTabItem[i1].getControl().isDisposed()) && (arrayOfCTabItem[i1].getControl().equals(localComposite)))
        return true;
    return false;
  }

  private void a(IBusinessObjectContainer paramIBusinessObjectContainer)
  {
    if (paramIBusinessObjectContainer == null)
      return;
    CTabItem localCTabItem = a(paramIBusinessObjectContainer.getDisplayName(), paramIBusinessObjectContainer.getEditUuid(), paramIBusinessObjectContainer);
    if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
      if ((paramIBusinessObjectContainer instanceof ValueLibrary))
        localCTabItem.getControl().setData(new aR(paramIBusinessObjectContainer, (Composite)localCTabItem.getControl(), this));
      else
        localCTabItem.getControl().setData(new com.flagleader.builder.a.b.e(paramIBusinessObjectContainer, (Composite)localCTabItem.getControl(), this));
  }

  private boolean a(IPackageElement paramIPackageElement)
  {
    return (paramIPackageElement.getMainPackage() == null) || (paramIPackageElement.getMainPackage().isDeveloper());
  }

  private void b(IRuleSet paramIRuleSet)
  {
    CTabItem localCTabItem;
    if (a(paramIRuleSet, "flow"))
    {
      if (((paramIRuleSet instanceof RuleSetFlow)) && ((a((RuleSetFlow)paramIRuleSet)) || (((RuleSetFlow)paramIRuleSet).getVml() == 0)))
      {
        localCTabItem = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".flow"), paramIRuleSet.getEditUuid() + "flow", paramIRuleSet);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new aX((RuleSetFlow)paramIRuleSet, (Composite)localCTabItem.getControl(), this));
      }
      if (((paramIRuleSet instanceof RuleTreeFlow)) && ((a((RuleTreeFlow)paramIRuleSet)) || (((RuleTreeFlow)paramIRuleSet).getVml() == 0)))
      {
        localCTabItem = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".flow"), paramIRuleSet.getEditUuid() + "tree", paramIRuleSet);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new cG((RuleTreeFlow)paramIRuleSet, (Composite)localCTabItem.getControl(), this));
      }
      if (((paramIRuleSet instanceof RulePoolFlow)) && ((a((RulePoolFlow)paramIRuleSet)) || (((RulePoolFlow)paramIRuleSet).getVml() == 0)))
      {
        localCTabItem = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".flow"), paramIRuleSet.getEditUuid() + "tree", paramIRuleSet);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new com.flagleader.builder.a.f.bu((RulePoolFlow)paramIRuleSet, (Composite)localCTabItem.getControl(), this));
      }
    }
    if ((a(paramIRuleSet, "edit")) && ((paramIRuleSet instanceof AbstractRuleSet)) && ((((AbstractRuleSet)paramIRuleSet).isFirst()) || (((AbstractRuleSet)paramIRuleSet).isSupportCatch())) && ((a((AbstractRuleSet)paramIRuleSet)) || (((AbstractRuleSet)paramIRuleSet).getVml() == 0)))
    {
      localCTabItem = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".edit"), paramIRuleSet.getEditUuid(), paramIRuleSet);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new bb(((AbstractRuleSet)paramIRuleSet).getRuleSetToken(), (Composite)localCTabItem.getControl(), this));
    }
    if ((a(paramIRuleSet, "rules")) && ((paramIRuleSet instanceof RulePackage)))
    {
      localCTabItem = a(paramIRuleSet.getDisplayName(), paramIRuleSet.getEditUuid() + "rules", paramIRuleSet);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.e.a((RulePackage)paramIRuleSet, (Composite)localCTabItem.getControl(), this));
    }
    if ((a(paramIRuleSet, "java")) && (a(paramIRuleSet)))
    {
      localCTabItem = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".java"), paramIRuleSet.getEditUuid() + "jav", paramIRuleSet);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new bK(paramIRuleSet, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramIRuleSet, "test"))
    {
      if ((paramIRuleSet instanceof IRuleClass))
        a((IRuleClass)paramIRuleSet);
      if (paramIRuleSet.needCheckSubRule())
      {
        localCTabItem = a(ResourceTools.getMessage("batchtest.RuleEditor"), paramIRuleSet.getEditUuid() + "batch", paramIRuleSet);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new com.flagleader.builder.a.g.a(paramIRuleSet, (Composite)localCTabItem.getControl(), this));
      }
    }
  }

  private void c(IRuleSet paramIRuleSet)
  {
    Object localObject;
    if (a(paramIRuleSet, "edit"))
    {
      if (((paramIRuleSet instanceof AbstractRuleSet)) && ((((AbstractRuleSet)paramIRuleSet).getEditType() != 0) || (((AbstractRuleSet)paramIRuleSet).isFirst()) || (((AbstractRuleSet)paramIRuleSet).isSupportCatch())) && ((a((AbstractRuleSet)paramIRuleSet)) || (((AbstractRuleSet)paramIRuleSet).getVml() == 0)))
      {
        if (((AbstractRuleSet)paramIRuleSet).getEditType() == 0)
          localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".edit2"), paramIRuleSet.getEditUuid(), paramIRuleSet);
        else
          localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".edit"), paramIRuleSet.getEditUuid(), paramIRuleSet);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new cg(((AbstractRuleSet)paramIRuleSet).getRuleSetToken(), (Composite)((CTabItem)localObject).getControl(), this));
      }
      if (((paramIRuleSet instanceof RuleSet)) && (((RuleSet)paramIRuleSet).isEditTable()))
      {
        localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".table"), paramIRuleSet.getEditUuid() + "table", paramIRuleSet);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new bQ((RuleSet)paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
      }
    }
    if (a(paramIRuleSet, "flow"))
    {
      if (((paramIRuleSet instanceof RuleSetFlow)) && ((a((RuleSetFlow)paramIRuleSet)) || (((RuleSetFlow)paramIRuleSet).getVml() == 0)))
      {
        localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".flow"), paramIRuleSet.getEditUuid() + "flow", paramIRuleSet);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new aX((RuleSetFlow)paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
      }
      if (((paramIRuleSet instanceof RuleTreeFlow)) && ((a((RuleTreeFlow)paramIRuleSet)) || (((RuleTreeFlow)paramIRuleSet).getVml() == 0)))
      {
        localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".flow"), paramIRuleSet.getEditUuid() + "tree", paramIRuleSet);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new cG((RuleTreeFlow)paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
      }
      if (((paramIRuleSet instanceof RulePoolFlow)) && ((a((RulePoolFlow)paramIRuleSet)) || (((RulePoolFlow)paramIRuleSet).getVml() == 0)))
      {
        localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".flow"), paramIRuleSet.getEditUuid() + "tree", paramIRuleSet);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new com.flagleader.builder.a.f.bu((RulePoolFlow)paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
      }
    }
    if ((a(paramIRuleSet, "rules")) && ((paramIRuleSet instanceof RulePackage)))
    {
      localObject = a(paramIRuleSet.getDisplayName(), paramIRuleSet.getEditUuid() + "rules", paramIRuleSet);
      if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
        ((CTabItem)localObject).getControl().setData(new com.flagleader.builder.a.e.a((RulePackage)paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
    }
    if (a(paramIRuleSet, "view"))
    {
      if (((paramIRuleSet instanceof RuleSet)) && (paramIRuleSet.getMainPackage() != null) && (paramIRuleSet.getMainPackage().canFindHistory()))
      {
        localObject = paramIRuleSet.getMainPackage().findRuleHistory(paramIRuleSet.getUuid(), paramIRuleSet.toString());
        if ((localObject != null) && ((localObject instanceof RuleSet)))
        {
          CTabItem localCTabItem = a(ResourceTools.getMessage("history.text"), ((RuleSet)localObject).getEditUuid(), paramIRuleSet);
          if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
            localCTabItem.getControl().setData(new com.flagleader.builder.a.f.aW(((RuleSet)localObject).getRuleSetToken(), (Composite)localCTabItem.getControl(), this));
        }
      }
      if (((paramIRuleSet instanceof RuleSet)) || ((paramIRuleSet instanceof RulePackage)))
        b(paramIRuleSet);
    }
    if ((a(paramIRuleSet, "java")) && (a(paramIRuleSet)))
    {
      localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".java"), paramIRuleSet.getEditUuid() + "jav", paramIRuleSet);
      if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
        ((CTabItem)localObject).getControl().setData(new bK(paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
    }
    if (a(paramIRuleSet, "test"))
    {
      if ((paramIRuleSet instanceof IRuleClass))
        a((IRuleClass)paramIRuleSet);
      if (paramIRuleSet.needCheckSubRule())
      {
        localObject = a(ResourceTools.getMessage("batchtest.RuleEditor"), paramIRuleSet.getEditUuid() + "batch", paramIRuleSet);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new com.flagleader.builder.a.g.a(paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
      }
    }
    if ((paramIRuleSet instanceof RulePackage))
    {
      if (a(paramIRuleSet, "env"))
      {
        localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".env"), paramIRuleSet.getEditUuid() + "html", paramIRuleSet);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new com.flagleader.builder.a.f.be(paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
      }
      if ((((RulePackage)paramIRuleSet).isDeveloper()) && (a(paramIRuleSet, "text")))
      {
        localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".text"), paramIRuleSet.getEditUuid() + "view", paramIRuleSet);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new cE(paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
      }
    }
    if ((a(paramIRuleSet, "code")) && ((paramIRuleSet instanceof RulePackage)) && (k()) && (((RulePackage)paramIRuleSet).isDeveloper()))
    {
      localObject = a(ResourceTools.getMessage(paramIRuleSet.getName() + ".code"), paramIRuleSet.getEditUuid() + "java", paramIRuleSet);
      if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
        if ((paramIRuleSet instanceof RulePackage))
          ((CTabItem)localObject).getControl().setData(new bn((RulePackage)paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
        else if ((paramIRuleSet instanceof RuleSet))
          ((CTabItem)localObject).getControl().setData(new bK((RuleSet)paramIRuleSet, (Composite)((CTabItem)localObject).getControl(), this));
    }
  }

  private void b(IPackageElement paramIPackageElement)
  {
    if ((!a(paramIPackageElement, "view")) || (!SystemUtils.IS_OS_WINDOWS))
      return;
    CTabItem localCTabItem = a(ResourceTools.getMessage(paramIPackageElement.getName() + ".view"), paramIPackageElement.getEditUuid() + "brower", paramIPackageElement);
    if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
      localCTabItem.getControl().setData(new da(paramIPackageElement, (Composite)localCTabItem.getControl(), this));
  }

  private boolean k()
  {
    return !this.f.isPlugInApp();
  }

  private void a(CustomFunction paramCustomFunction)
  {
    if (!a(paramCustomFunction))
      return;
    if (a(paramCustomFunction, "edit"))
    {
      CTabItem localCTabItem = a(ResourceTools.getMessage(paramCustomFunction.getName() + ".edit"), paramCustomFunction.getEditUuid(), paramCustomFunction);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new as(paramCustomFunction, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(Envionment paramEnvionment)
  {
    CTabItem localCTabItem = null;
    Composite localComposite = null;
    if ((this.f.getWindowsManager().h()) && (this.n != null) && (!this.n.isDisposed()))
    {
      localCTabItem = this.n;
      if ((localCTabItem.getData() != null) && (localCTabItem.getData().equals(paramEnvionment)))
        return;
      if ((localCTabItem.getControl() != null) && (!localCTabItem.getControl().isDisposed()))
        localCTabItem.getControl().dispose();
      if ((localComposite == null) || (localComposite.isDisposed()))
      {
        localComposite = c(this.b);
        localComposite.setBackground(com.flagleader.builder.widget.h.d);
        localComposite.setData(new com.flagleader.builder.a.b.I(paramEnvionment, localComposite, this));
      }
      localCTabItem.setControl(localComposite);
      localCTabItem.setData(paramEnvionment);
      if (((IElementViewer)localComposite.getData()).needUpdate())
        ((IElementViewer)localComposite.getData()).update();
    }
  }

  private void c(ITreeNode paramITreeNode)
  {
    CTabItem localCTabItem = null;
    Composite localComposite = null;
    String str;
    if (this.f.getWindowsManager().h())
    {
      str = paramITreeNode.getEditUuid() + "props";
      localCTabItem = this.l;
    }
    else
    {
      localCTabItem = new CTabItem(this.a, 0);
      str = paramITreeNode.getEditUuid() + "props1";
      localComposite = b(str);
      localCTabItem.setText(ResourceTools.getMessage("Properties.edit"));
      if ((localComposite != null) && (localComposite.getParent() != this.a))
      {
        this.d.remove(str);
        localComposite.dispose();
      }
    }
    if ((localComposite == null) || (localComposite.isDisposed()))
    {
      if (this.f.getWindowsManager().h())
        localComposite = c(this.b);
      else
        localComposite = c(this.a);
      localComposite.setBackground(com.flagleader.builder.widget.h.d);
      if ((paramITreeNode instanceof Envionment))
        localComposite.setData(new com.flagleader.builder.c.a((Envionment)paramITreeNode, localComposite, this));
      else if ((paramITreeNode instanceof RulePackage))
        localComposite.setData(new i((RulePackage)paramITreeNode, localComposite, this));
      else
        localComposite.setData(new x(paramITreeNode, localComposite, this));
      if (!this.f.getWindowsManager().h())
        b(str, localComposite);
    }
    localCTabItem.setControl(localComposite);
    localCTabItem.setData(paramITreeNode);
    if ((this.f.getWindowsManager().h()) && (((IElementViewer)localComposite.getData()).needUpdate()))
      ((IElementViewer)localComposite.getData()).update();
    if (((paramITreeNode instanceof IRuleTree)) && (((IRuleTree)paramITreeNode).getEnvionment() != null))
      b(((IRuleTree)paramITreeNode).getEnvionment());
  }

  private void a(DBModel paramDBModel)
  {
    h();
    b(paramDBModel);
    c(paramDBModel);
  }

  private void a(BOContainerGroup paramBOContainerGroup)
  {
    h();
    b(paramBOContainerGroup);
    c(paramBOContainerGroup);
  }

  private void b(DBModel paramDBModel)
  {
    if (!a(paramDBModel))
      return;
    if (a(paramDBModel, "edit"))
    {
      CTabItem localCTabItem = a(paramDBModel.getDisplayName(), paramDBModel.getEditUuid(), paramDBModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new G(paramDBModel, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(BOContainerGroup paramBOContainerGroup)
  {
    if (!a(paramBOContainerGroup))
      return;
    if (a(paramBOContainerGroup, "edit"))
    {
      CTabItem localCTabItem = a(paramBOContainerGroup.getDisplayName(), paramBOContainerGroup.getEditUuid(), paramBOContainerGroup);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.b.a(paramBOContainerGroup, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void a(ExcelBookModel paramExcelBookModel)
  {
    h();
    if (a(paramExcelBookModel, "func"))
    {
      CTabItem localCTabItem = a(ResourceTools.getMessage(paramExcelBookModel.getName() + ".func"), paramExcelBookModel.getEditUuid(), paramExcelBookModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new V(paramExcelBookModel, (Composite)localCTabItem.getControl(), this));
    }
    c(paramExcelBookModel);
  }

  private void a(ExcelSheetModel paramExcelSheetModel)
  {
    h();
    if (a(paramExcelSheetModel, "func"))
    {
      CTabItem localCTabItem = a(ResourceTools.getMessage(paramExcelSheetModel.getName() + ".func"), paramExcelSheetModel.getEditUuid(), paramExcelSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new V(paramExcelSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    c(paramExcelSheetModel);
  }

  private void a(ExcelTableSheetModel paramExcelTableSheetModel)
  {
    h();
    CTabItem localCTabItem;
    if (a(paramExcelTableSheetModel, "edit"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramExcelTableSheetModel.getName() + ".edit"), paramExcelTableSheetModel.getEditUuid() + "field", paramExcelTableSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.b.X(paramExcelTableSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramExcelTableSheetModel, "func"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramExcelTableSheetModel.getName() + ".func"), paramExcelTableSheetModel.getEditUuid(), paramExcelTableSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new V(paramExcelTableSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramExcelTableSheetModel, "func"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramExcelTableSheetModel.getName() + ".data"), paramExcelTableSheetModel.getEditUuid() + "data", paramExcelTableSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new aa(paramExcelTableSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    c(paramExcelTableSheetModel);
  }

  private void a(ExcelXYSheetModel paramExcelXYSheetModel)
  {
    h();
    CTabItem localCTabItem;
    if (a(paramExcelXYSheetModel, "edit"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramExcelXYSheetModel.getName() + ".edit"), paramExcelXYSheetModel.getEditUuid() + "field", paramExcelXYSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.b.X(paramExcelXYSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramExcelXYSheetModel, "col"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramExcelXYSheetModel.getName() + ".col"), paramExcelXYSheetModel.getEditUuid() + "col", paramExcelXYSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new S(paramExcelXYSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramExcelXYSheetModel, "cell"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramExcelXYSheetModel.getName() + ".cell"), paramExcelXYSheetModel.getEditUuid() + "cell", paramExcelXYSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new N(paramExcelXYSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramExcelXYSheetModel, "func"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramExcelXYSheetModel.getName() + ".func"), paramExcelXYSheetModel.getEditUuid(), paramExcelXYSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new V(paramExcelXYSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramExcelXYSheetModel, "func"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramExcelXYSheetModel.getName() + ".data"), paramExcelXYSheetModel.getEditUuid() + "data", paramExcelXYSheetModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new aj(paramExcelXYSheetModel, (Composite)localCTabItem.getControl(), this));
    }
    c(paramExcelXYSheetModel);
  }

  private void a(XmlNode paramXmlNode)
  {
    h();
    b(paramXmlNode);
    if (((paramXmlNode instanceof XmlNode)) && (paramXmlNode.isDevelopModel()))
      c(paramXmlNode);
  }

  private void a(TreeValueNode paramTreeValueNode)
  {
    h();
    b(paramTreeValueNode);
    if (((paramTreeValueNode instanceof TreeValueNode)) && (paramTreeValueNode.isDevelopModel()))
      c(paramTreeValueNode);
  }

  private void a(ClassContainer paramClassContainer)
  {
    h();
    b(paramClassContainer);
    if (((paramClassContainer instanceof ClassContainer)) && (paramClassContainer.isDevelopModel()))
      c(paramClassContainer);
  }

  private void b(ClassContainer paramClassContainer)
  {
    if (a(paramClassContainer, "func"))
    {
      CTabItem localCTabItem = a(paramClassContainer.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramClassContainer.getName())).append(".func").toString()), paramClassContainer.getEditUuid() + "func", paramClassContainer);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new E(paramClassContainer, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void a(InterfaceContainer paramInterfaceContainer)
  {
    h();
    b(paramInterfaceContainer);
    if (((paramInterfaceContainer instanceof InterfaceContainer)) && (paramInterfaceContainer.isDevelopModel()))
      c(paramInterfaceContainer);
  }

  private void b(InterfaceContainer paramInterfaceContainer)
  {
    if (a(paramInterfaceContainer, "func"))
    {
      CTabItem localCTabItem = a(paramInterfaceContainer.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramInterfaceContainer.getName())).append(".func").toString()), paramInterfaceContainer.getEditUuid() + "func", paramInterfaceContainer);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new av(paramInterfaceContainer, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void a(SoapService paramSoapService)
  {
    h();
    b(paramSoapService);
    if (((paramSoapService instanceof SoapService)) && (paramSoapService.isDevelopModel()))
      c(paramSoapService);
  }

  private void b(SoapService paramSoapService)
  {
    if (!a(paramSoapService))
      return;
    CTabItem localCTabItem;
    if (a(paramSoapService, "p"))
    {
      localCTabItem = a(paramSoapService.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSoapService.getName())).append(".prop").toString()), paramSoapService.getEditUuid() + "props", paramSoapService);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new az(paramSoapService, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramSoapService, "func"))
    {
      localCTabItem = a(paramSoapService.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSoapService.getName())).append(".func").toString()), paramSoapService.getEditUuid() + "func", paramSoapService);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.b.ax(paramSoapService, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramSoapService, "test"))
    {
      localCTabItem = a(paramSoapService.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSoapService.getName())).append(".test").toString()), paramSoapService.getEditUuid() + "test", paramSoapService);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new aB(paramSoapService, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(XmlNode paramXmlNode)
  {
    if (!a(paramXmlNode))
      return;
    CTabItem localCTabItem;
    if (a(paramXmlNode, "func"))
    {
      localCTabItem = a(paramXmlNode.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramXmlNode.getName())).append(".func").toString()), paramXmlNode.getEditUuid() + "func", paramXmlNode);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.b.aW(paramXmlNode, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramXmlNode, "p"))
    {
      localCTabItem = a(paramXmlNode.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramXmlNode.getName())).append(".prop").toString()), paramXmlNode.getEditUuid() + "props", paramXmlNode);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.b.aS(paramXmlNode, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramXmlNode, "xml"))
    {
      localCTabItem = a(paramXmlNode.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramXmlNode.getName())).append(".xml").toString()), paramXmlNode.getEditUuid() + "xml", paramXmlNode);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new aU(paramXmlNode, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(TreeValueNode paramTreeValueNode)
  {
    if (!a(paramTreeValueNode))
      return;
    CTabItem localCTabItem;
    if (a(paramTreeValueNode, "p"))
    {
      localCTabItem = a(paramTreeValueNode.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramTreeValueNode.getName())).append(".prop").toString()), paramTreeValueNode.getEditUuid() + "props", paramTreeValueNode);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new aL(paramTreeValueNode, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramTreeValueNode, "func"))
    {
      localCTabItem = a(paramTreeValueNode.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramTreeValueNode.getName())).append(".func").toString()), paramTreeValueNode.getEditUuid() + "func", paramTreeValueNode);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new aP(paramTreeValueNode, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramTreeValueNode, "xml"))
    {
      localCTabItem = a(paramTreeValueNode.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramTreeValueNode.getName())).append(".xml").toString()), paramTreeValueNode.getEditUuid() + "xml", paramTreeValueNode);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.b.aN(paramTreeValueNode, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void a(TableModel paramTableModel)
  {
    h();
    b(paramTableModel);
    c(paramTableModel);
  }

  private void a(ViewModel paramViewModel)
  {
    h();
    b(paramViewModel);
    c(paramViewModel);
  }

  private void a(SelectTable paramSelectTable)
  {
    h();
    b(paramSelectTable);
    c(paramSelectTable);
  }

  private void a(SheetTable paramSheetTable)
  {
    h();
    b(paramSheetTable);
    c(paramSheetTable);
  }

  private void a(SheetMap paramSheetMap)
  {
    h();
    b(paramSheetMap);
    c(paramSheetMap);
  }

  private void a(EnumTable paramEnumTable)
  {
    h();
    b(paramEnumTable);
    c(paramEnumTable);
  }

  private void a(CustomSql paramCustomSql)
  {
    h();
    if ((a(paramCustomSql)) && (a(paramCustomSql, "sql")))
    {
      CTabItem localCTabItem = a(ResourceTools.getMessage(paramCustomSql.getName() + ".sql"), paramCustomSql.getEditUuid(), paramCustomSql);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.a.h(paramCustomSql, (Composite)localCTabItem.getControl(), this));
    }
    c(paramCustomSql);
  }

  private void a(ProcedureModel paramProcedureModel)
  {
    h();
    b(paramProcedureModel);
    c(paramProcedureModel);
  }

  private void b(SelectTable paramSelectTable)
  {
    CTabItem localCTabItem;
    if (a(paramSelectTable, "func"))
    {
      localCTabItem = a(paramSelectTable.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSelectTable.getName())).append(".func").toString()), paramSelectTable.getEditUuid() + "func", paramSelectTable);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new au(paramSelectTable, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramSelectTable, "field"))
    {
      localCTabItem = a(paramSelectTable.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSelectTable.getName())).append(".edit").toString()), paramSelectTable.getEditUuid() + "field", paramSelectTable);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new B(paramSelectTable, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramSelectTable, "sql"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramSelectTable.getName() + ".sql"), paramSelectTable.getEditUuid() + "sql", paramSelectTable);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.a.I(paramSelectTable, (Composite)localCTabItem.getControl(), this));
    }
    if ((a(paramSelectTable, "data")) && (a(paramSelectTable)))
    {
      localCTabItem = a(paramSelectTable.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSelectTable.getName())).append(".data").toString()), paramSelectTable.getEditUuid() + "data", paramSelectTable);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new A(paramSelectTable, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(SheetTable paramSheetTable)
  {
    CTabItem localCTabItem;
    if (a(paramSheetTable, "field"))
    {
      localCTabItem = a(paramSheetTable.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSheetTable.getName())).append(".edit").toString()), paramSheetTable.getEditUuid() + "field", paramSheetTable);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.a.X(paramSheetTable, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramSheetTable, "func"))
    {
      localCTabItem = a(paramSheetTable.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSheetTable.getName())).append(".func").toString()), paramSheetTable.getEditUuid() + "func", paramSheetTable);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new Y(paramSheetTable, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramSheetTable, "data"))
    {
      localCTabItem = a(paramSheetTable.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSheetTable.getName())).append(".data").toString()), paramSheetTable.getEditUuid() + "data", paramSheetTable);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new M(paramSheetTable, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(SheetMap paramSheetMap)
  {
    CTabItem localCTabItem;
    if (a(paramSheetMap, "data"))
    {
      localCTabItem = a(paramSheetMap.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSheetMap.getName())).append(".data").toString()), paramSheetMap.getEditUuid() + "field", paramSheetMap);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new ai(paramSheetMap, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramSheetMap, "func"))
    {
      localCTabItem = a(paramSheetMap.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramSheetMap.getName())).append(".func").toString()), paramSheetMap.getEditUuid() + "func", paramSheetMap);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new ak(paramSheetMap, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(EnumTable paramEnumTable)
  {
    if (a(paramEnumTable, "func"))
    {
      CTabItem localCTabItem = a(paramEnumTable.getDisplayName(), paramEnumTable.getEditUuid() + "func", paramEnumTable);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new l(paramEnumTable, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(ProcedureModel paramProcedureModel)
  {
    CTabItem localCTabItem;
    if (a(paramProcedureModel, "func"))
    {
      localCTabItem = a(paramProcedureModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramProcedureModel.getName())).append(".func").toString()), paramProcedureModel.getEditUuid() + "func", paramProcedureModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new au(paramProcedureModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramProcedureModel, "para"))
    {
      localCTabItem = a(paramProcedureModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramProcedureModel.getName())).append(".para").toString()), paramProcedureModel.getEditUuid() + "para", paramProcedureModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.a.o(paramProcedureModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramProcedureModel, "field"))
    {
      localCTabItem = a(paramProcedureModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramProcedureModel.getName())).append(".field").toString()), paramProcedureModel.getEditUuid() + "field", paramProcedureModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new n(paramProcedureModel, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(TableModel paramTableModel)
  {
    CTabItem localCTabItem;
    if (a(paramTableModel, "func"))
    {
      localCTabItem = a(paramTableModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramTableModel.getName())).append(".func").toString()), paramTableModel.getEditUuid() + "func", paramTableModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new au(paramTableModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramTableModel, "field"))
    {
      localCTabItem = a(paramTableModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramTableModel.getName())).append(".edit").toString()), paramTableModel.getEditUuid() + "field", paramTableModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new an(paramTableModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramTableModel, "fk"))
    {
      localCTabItem = a(paramTableModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramTableModel.getName())).append(".fk").toString()), paramTableModel.getEditUuid() + "fk", paramTableModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new am(paramTableModel, (Composite)localCTabItem.getControl(), this));
    }
    if ((a(paramTableModel, "data")) && (a(paramTableModel)))
    {
      localCTabItem = a(paramTableModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramTableModel.getName())).append(".data").toString()), paramTableModel.getEditUuid() + "data", paramTableModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.a.al(paramTableModel, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void b(ViewModel paramViewModel)
  {
    CTabItem localCTabItem;
    if (a(paramViewModel, "func"))
    {
      localCTabItem = a(paramViewModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramViewModel.getName())).append(".func").toString()), paramViewModel.getEditUuid() + "func", paramViewModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new au(paramViewModel, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramViewModel, "field"))
    {
      localCTabItem = a(paramViewModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramViewModel.getName())).append(".edit").toString()), paramViewModel.getEditUuid() + "field", paramViewModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.a.ax(paramViewModel, (Composite)localCTabItem.getControl(), this));
    }
    if ((a(paramViewModel, "data")) && (a(paramViewModel)))
    {
      localCTabItem = a(paramViewModel.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramViewModel.getName())).append(".data").toString()), paramViewModel.getEditUuid() + "data", paramViewModel);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new aw(paramViewModel, (Composite)localCTabItem.getControl(), this));
    }
  }

  private void a(IRule paramIRule)
  {
    if (!a(paramIRule))
      return;
    if (!a(paramIRule, "java"))
      return;
    CTabItem localCTabItem = a(ResourceTools.getMessage(paramIRule.getName() + ".java"), paramIRule.getEditUuid() + "java", paramIRule);
    if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
      localCTabItem.getControl().setData(new bj(paramIRule, (Composite)localCTabItem.getControl(), this));
  }

  private void a(IRuleClass paramIRuleClass)
  {
    if ((!a(paramIRuleClass)) && (!(paramIRuleClass instanceof RulePackage)))
      return;
    if (!a(paramIRuleClass, "test"))
      return;
    CTabItem localCTabItem = new CTabItem(this.a, 0);
    if ((paramIRuleClass instanceof RulePackage))
      localCTabItem.setText(ResourceTools.getMessage("rules.test"));
    else
      localCTabItem.setText(ResourceTools.getMessage("rule.test"));
    Composite localComposite = b(paramIRuleClass.getEditUuid() + "test");
    if ((localComposite == null) || (localComposite.isDisposed()))
    {
      localComposite = j();
      localComposite.setBackground(com.flagleader.builder.widget.h.d);
      localComposite.setData(new do(paramIRuleClass, localComposite, this));
      b(paramIRuleClass.getEditUuid() + "test", localComposite);
    }
    localCTabItem.setControl(localComposite);
    localCTabItem.setData(paramIRuleClass);
  }

  private void a(Rule paramRule)
  {
    h();
    Object localObject;
    if (paramRule.isEditTable())
    {
      if (a(paramRule, "edit"))
      {
        localObject = a(ResourceTools.getMessage(paramRule.getName() + ".table"), paramRule.getEditUuid() + "value", paramRule);
        if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
          ((CTabItem)localObject).getControl().setData(new ck(paramRule, (Composite)((CTabItem)localObject).getControl(), this));
        b(paramRule);
      }
    }
    else if (a(paramRule, "edit"))
    {
      b(paramRule);
      localObject = a(ResourceTools.getMessage(paramRule.getName() + ".table"), paramRule.getEditUuid() + "value", paramRule);
      if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
        ((CTabItem)localObject).getControl().setData(new ck(paramRule, (Composite)((CTabItem)localObject).getControl(), this));
    }
    if ((paramRule.getMainPackage() != null) && (paramRule.getMainPackage().canFindHistory()))
    {
      localObject = paramRule.getMainPackage().findRuleHistory(paramRule.getUuid(), paramRule.toString());
      if ((localObject != null) && ((localObject instanceof Rule)))
      {
        CTabItem localCTabItem = a(ResourceTools.getMessage("history.text"), ((Rule)localObject).getEditUuid(), paramRule);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new com.flagleader.builder.a.f.aW(((Rule)localObject).getRuleElementToken(), (Composite)localCTabItem.getControl(), this));
      }
    }
    a(paramRule);
    b(paramRule);
    if (a(paramRule, "text"))
    {
      localObject = a(ResourceTools.getMessage(paramRule.getName() + ".text"), paramRule.getEditUuid() + "view", paramRule);
      if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
        ((CTabItem)localObject).getControl().setData(new cE(paramRule, (Composite)((CTabItem)localObject).getControl(), this));
    }
    a(paramRule);
    if ((paramRule.getEnvionment().isVisible()) && (a(paramRule)))
      c(paramRule.getEnvionment());
    if ((paramRule instanceof Rule))
      c(paramRule);
  }

  private void a(DecisionRule paramDecisionRule)
  {
    h();
    Object localObject1 = null;
    Object localObject2;
    if ((a(paramDecisionRule)) || (paramDecisionRule.canVmlShow()))
    {
      if (a(paramDecisionRule, "value"))
      {
        localObject2 = a(paramDecisionRule.getDisplayName() + ResourceTools.getMessage("decisionvalue.edit"), paramDecisionRule.getEditUuid() + "value", paramDecisionRule);
        if ((localObject2 != null) && (((CTabItem)localObject2).getControl() != null) && (((CTabItem)localObject2).getControl().getData() == null))
          ((CTabItem)localObject2).getControl().setData(new af(paramDecisionRule, (Composite)((CTabItem)localObject2).getControl(), this));
      }
      if (a(paramDecisionRule, "edit"))
      {
        localObject2 = a(paramDecisionRule.getDisplayName() + ResourceTools.getMessage("decisioncondition.edit"), paramDecisionRule.getEditUuid(), paramDecisionRule);
        if ((localObject2 != null) && (((CTabItem)localObject2).getControl() != null) && (((CTabItem)localObject2).getControl().getData() == null))
          ((CTabItem)localObject2).getControl().setData(new com.flagleader.builder.a.f.aW(paramDecisionRule, (Composite)((CTabItem)localObject2).getControl(), this));
      }
    }
    a(paramDecisionRule);
    if ((paramDecisionRule.getMainPackage() != null) && (paramDecisionRule.getMainPackage().canFindHistory()))
    {
      localObject2 = paramDecisionRule.getMainPackage().findRuleHistory(paramDecisionRule.getUuid(), paramDecisionRule.toString());
      if ((localObject2 != null) && ((localObject2 instanceof DecisionRule)))
      {
        CTabItem localCTabItem = a(ResourceTools.getMessage("history.text"), ((DecisionRule)localObject2).getEditUuid() + "value", paramDecisionRule);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new com.flagleader.builder.a.f.aN((DecisionRule)localObject2, (Composite)localCTabItem.getControl(), this));
      }
    }
    else
    {
      b(paramDecisionRule);
    }
    a(paramDecisionRule);
    if ((paramDecisionRule instanceof DecisionRule))
      c(paramDecisionRule);
  }

  private void a(RuleMirror paramRuleMirror)
  {
    h();
    if ((paramRuleMirror.getMemberElement() != null) && ((paramRuleMirror.getMemberElement() instanceof IPackageElement)))
      b((IPackageElement)paramRuleMirror.getMemberElement());
    if ((paramRuleMirror instanceof RuleMirror))
      c(paramRuleMirror);
  }

  private void a(DecisionMultiRule paramDecisionMultiRule)
  {
    h();
    Object localObject;
    if (a(paramDecisionMultiRule, "value"))
    {
      localObject = a(paramDecisionMultiRule.getDisplayName() + ResourceTools.getMessage("decisionvalue.edit"), paramDecisionMultiRule.getEditUuid() + "value", paramDecisionMultiRule);
      if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
        ((CTabItem)localObject).getControl().setData(new com.flagleader.builder.a.f.a(paramDecisionMultiRule, (Composite)((CTabItem)localObject).getControl(), this));
    }
    if (a(paramDecisionMultiRule, "edit"))
    {
      localObject = a(paramDecisionMultiRule.getDisplayName() + ResourceTools.getMessage("decisioncondition.edit"), paramDecisionMultiRule.getEditUuid(), paramDecisionMultiRule);
      if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
        ((CTabItem)localObject).getControl().setData(new com.flagleader.builder.a.f.aW(paramDecisionMultiRule, (Composite)((CTabItem)localObject).getControl(), this));
    }
    a(paramDecisionMultiRule);
    if ((paramDecisionMultiRule.getMainPackage() != null) && (paramDecisionMultiRule.getMainPackage().canFindHistory()))
    {
      localObject = paramDecisionMultiRule.getMainPackage().findRuleHistory(paramDecisionMultiRule.getUuid(), paramDecisionMultiRule.toString());
      if ((localObject != null) && ((localObject instanceof DecisionMultiRule)))
      {
        CTabItem localCTabItem = a(ResourceTools.getMessage("history.text"), ((DecisionMultiRule)localObject).getEditUuid(), paramDecisionMultiRule);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new com.flagleader.builder.a.f.a((DecisionMultiRule)localObject, (Composite)localCTabItem.getControl(), this));
      }
    }
    else
    {
      b(paramDecisionMultiRule);
    }
    a(paramDecisionMultiRule);
    if ((paramDecisionMultiRule instanceof DecisionMultiRule))
      c(paramDecisionMultiRule);
  }

  private void a(ExpressionRule paramExpressionRule)
  {
    h();
    Object localObject;
    if (a(paramExpressionRule, "edit"))
    {
      localObject = a(paramExpressionRule.getDisplayName() + ResourceTools.getMessage("ExpressionRule.edit"), paramExpressionRule.getEditUuid(), paramExpressionRule);
      if ((localObject != null) && (((CTabItem)localObject).getControl() != null) && (((CTabItem)localObject).getControl().getData() == null))
        ((CTabItem)localObject).getControl().setData(new aT(paramExpressionRule, (Composite)((CTabItem)localObject).getControl(), this));
    }
    a(paramExpressionRule);
    if ((paramExpressionRule.getMainPackage() != null) && (paramExpressionRule.getMainPackage().canFindHistory()))
    {
      localObject = paramExpressionRule.getMainPackage().findRuleHistory(paramExpressionRule.getUuid(), paramExpressionRule.toString());
      if ((localObject != null) && ((localObject instanceof ExpressionRule)))
      {
        CTabItem localCTabItem = a(ResourceTools.getMessage("history.text"), ((ExpressionRule)localObject).getEditUuid(), paramExpressionRule);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new aT((ExpressionRule)localObject, (Composite)localCTabItem.getControl(), this));
      }
    }
    else
    {
      b(paramExpressionRule);
    }
    a(paramExpressionRule);
    if ((paramExpressionRule instanceof ExpressionRule))
      c(paramExpressionRule);
  }

  private void a(DecisionRelateRule paramDecisionRelateRule)
  {
    h();
    Object localObject1 = null;
    Object localObject2;
    if ((a(paramDecisionRelateRule)) || (paramDecisionRelateRule.canVmlShow()))
    {
      if (a(paramDecisionRelateRule, "value"))
      {
        localObject2 = a(paramDecisionRelateRule.getDisplayName() + ResourceTools.getMessage("decisionvalue.edit"), paramDecisionRelateRule.getEditUuid() + "value", paramDecisionRelateRule);
        if ((localObject2 != null) && (((CTabItem)localObject2).getControl() != null) && (((CTabItem)localObject2).getControl().getData() == null))
          ((CTabItem)localObject2).getControl().setData(new com.flagleader.builder.a.f.o(paramDecisionRelateRule, (Composite)((CTabItem)localObject2).getControl(), this));
      }
      if (a(paramDecisionRelateRule, "edit"))
      {
        localObject2 = a(paramDecisionRelateRule.getDisplayName() + ResourceTools.getMessage("decisioncondition.edit"), paramDecisionRelateRule.getEditUuid(), paramDecisionRelateRule);
        if ((localObject2 != null) && (((CTabItem)localObject2).getControl() != null) && (((CTabItem)localObject2).getControl().getData() == null))
          ((CTabItem)localObject2).getControl().setData(new com.flagleader.builder.a.f.aW(paramDecisionRelateRule, (Composite)((CTabItem)localObject2).getControl(), this));
      }
    }
    a(paramDecisionRelateRule);
    if ((paramDecisionRelateRule.getMainPackage() != null) && (paramDecisionRelateRule.getMainPackage().canFindHistory()))
    {
      localObject2 = paramDecisionRelateRule.getMainPackage().findRuleHistory(paramDecisionRelateRule.getUuid(), paramDecisionRelateRule.toString());
      if ((localObject2 != null) && ((localObject2 instanceof DecisionRelateRule)))
      {
        CTabItem localCTabItem = a(ResourceTools.getMessage("history.text"), ((DecisionRelateRule)localObject2).getEditUuid(), paramDecisionRelateRule);
        if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
          localCTabItem.getControl().setData(new com.flagleader.builder.a.f.X((DecisionRelateRule)localObject2, (Composite)localCTabItem.getControl(), this));
      }
    }
    else
    {
      b(paramDecisionRelateRule);
    }
    a(paramDecisionRelateRule);
    if ((paramDecisionRelateRule instanceof DecisionRelateRule))
      c(paramDecisionRelateRule);
  }

  private void c(Envionment paramEnvionment)
  {
    if (a(paramEnvionment, "value"))
      a(paramEnvionment.getValueLibrary());
    if (a(paramEnvionment, "temp"))
      a(paramEnvionment.getTempVariableLibrary());
    if (a(paramEnvionment, "static"))
      a(paramEnvionment.getFunctionLibrary());
    if (a(paramEnvionment, "enum"))
      a(paramEnvionment.getEnumLibrary());
  }

  public void a(Envionment paramEnvionment)
  {
    h();
    c(paramEnvionment);
    c(paramEnvionment);
  }

  public void a(IRuleSet paramIRuleSet)
  {
    h();
    if (((paramIRuleSet instanceof RuleSetFlow)) || ((paramIRuleSet instanceof RuleTreeFlow)) || ((paramIRuleSet instanceof RulePoolFlow)))
      b(paramIRuleSet);
    else
      c(paramIRuleSet);
    if ((((paramIRuleSet instanceof RuleSet)) || ((paramIRuleSet instanceof RuleSetFlow)) || ((paramIRuleSet instanceof RuleTreeFlow)) || ((paramIRuleSet instanceof RulePoolFlow))) && (paramIRuleSet.getEnvionment().isVisible()) && (a(paramIRuleSet)))
      c(paramIRuleSet.getEnvionment());
    c(paramIRuleSet);
    if ((!paramIRuleSet.isLocked()) && (this.f.getConfigManager().E()))
      this.f.getRulesManager().c().a(paramIRuleSet);
  }

  private boolean a(ITreeNode paramITreeNode, String paramString)
  {
    String[] arrayOfString = ResourceTools.getConfigArray(paramITreeNode.getName() + ".editor");
    for (int i1 = 0; (arrayOfString != null) && (i1 < arrayOfString.length); i1++)
      if (arrayOfString[i1].equalsIgnoreCase(paramString))
        return true;
    return false;
  }

  private void b(IRuleGroup paramIRuleGroup)
  {
    CTabItem localCTabItem;
    if (a(paramIRuleGroup, "rules"))
    {
      localCTabItem = a(paramIRuleGroup.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramIRuleGroup.getName())).append(".rules").toString()), paramIRuleGroup.getEditUuid() + "rules", paramIRuleGroup);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.e.h(paramIRuleGroup, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramIRuleGroup, "jsps"))
    {
      localCTabItem = a(paramIRuleGroup.getDisplayName() + ResourceTools.getMessage(new StringBuilder(String.valueOf(paramIRuleGroup.getName())).append(".jsps").toString()), paramIRuleGroup.getEditUuid() + "jsps", paramIRuleGroup);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.e.e(paramIRuleGroup, (Composite)localCTabItem.getControl(), this));
    }
    if (a(paramIRuleGroup, "table"))
    {
      localCTabItem = a(ResourceTools.getMessage(paramIRuleGroup.getName() + ".table"), paramIRuleGroup.getEditUuid() + "table", paramIRuleGroup);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.e.k(paramIRuleGroup, (Composite)localCTabItem.getControl(), this));
    }
  }

  public void a(IRuleGroup paramIRuleGroup)
  {
    h();
    b(paramIRuleGroup);
    c(paramIRuleGroup);
  }

  private void b(CustomFunction paramCustomFunction)
  {
    h();
    a(paramCustomFunction);
    c(paramCustomFunction.getEnvionment());
    if (paramCustomFunction.isDevelopModel())
      c(paramCustomFunction);
  }

  private void a(TestCase paramTestCase)
  {
    h();
    if (a(paramTestCase, "test"))
    {
      CTabItem localCTabItem = a(paramTestCase.getDisplayName(), paramTestCase.getEditUuid(), paramTestCase);
      if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
        localCTabItem.getControl().setData(new com.flagleader.builder.a.g.k(paramTestCase, (Composite)localCTabItem.getControl(), this));
      c(paramTestCase);
    }
  }

  private void a(TestCaseLib paramTestCaseLib)
  {
    h();
    CTabItem localCTabItem = a(paramTestCaseLib.getDisplayName(), paramTestCaseLib.getEditUuid() + "test", paramTestCaseLib);
    if ((localCTabItem != null) && (localCTabItem.getControl() != null) && (localCTabItem.getControl().getData() == null))
      localCTabItem.getControl().setData(new com.flagleader.builder.a.g.r(paramTestCaseLib, (Composite)localCTabItem.getControl(), this));
    c(paramTestCaseLib);
  }

  public void a(IPage paramIPage)
  {
    h();
    if (!a(paramIPage))
      return;
    CTabItem localCTabItem1;
    if (a(paramIPage, "page"))
    {
      localCTabItem1 = a(ResourceTools.getMessage("field.exportModel"), paramIPage.getEditUuid() + "page", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new W(paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if ((a(paramIPage, "element")) && (paramIPage.getPreferences().getStringArray(paramIPage.getImportFile() + ".elementType") != null))
    {
      localCTabItem1 = a(ResourceTools.getMessage("element.exportModel", "elements"), paramIPage.getEditUuid() + "element", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new P(paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if (a(paramIPage, "define"))
    {
      localCTabItem1 = a(ResourceTools.getMessage("define.exportModel"), paramIPage.getEditUuid() + "props", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new aI(paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if (((paramIPage instanceof ExportModel)) && (a(paramIPage, "model")) && (((ExportModel)paramIPage).getModelStr().length() > 0))
    {
      localCTabItem1 = a(ResourceTools.getMessage("model.exportModel"), paramIPage.getEditUuid() + "model", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new com.flagleader.builder.a.d.ax((ExportModel)paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if ((a(paramIPage, "modelhtml")) && (paramIPage.exitsDesignFile("d_")))
    {
      localCTabItem1 = a(ResourceTools.getMessage("modelhtml.exportModel", "html"), paramIPage.getEditUuid() + "modelhtml", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new com.flagleader.builder.a.d.I(paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if (a(paramIPage, "result"))
    {
      localCTabItem1 = a(paramIPage.getDisplayName(), paramIPage.getEditUuid() + "jsp", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new aY(paramIPage, (Composite)localCTabItem1.getControl(), this));
      if (paramIPage.getModelStr().length() == 0)
      {
        String[] arrayOfString = paramIPage.getPreferences().getStringArray(paramIPage.getImportFile() + ".extends");
        if (arrayOfString != null)
          for (int i1 = 0; i1 < arrayOfString.length; i1++)
          {
            String str1 = paramIPage.getPreferences().getString(arrayOfString[i1] + ".export");
            if (str1 == null)
              continue;
            String str2 = StringUtil.replace("{pname}", paramIPage.getPName(), str1);
            str2 = StringUtil.replace("{fname}", paramIPage.getFName(), str2);
            str2 = StringUtil.replace("{local}", Locale.getDefault().toString(), str2);
            File localFile = new File(i().getConfigManager().d(), str2);
            CTabItem localCTabItem2 = a(localFile.getName(), paramIPage.getEditUuid() + arrayOfString[i1], paramIPage);
            if ((localCTabItem2 == null) || (localCTabItem2.getControl() == null) || (localCTabItem2.getControl().getData() != null))
              continue;
            localCTabItem2.getControl().setData(new com.flagleader.builder.a.d.aS(paramIPage, arrayOfString[i1], (Composite)localCTabItem2.getControl(), this));
          }
      }
    }
    if ((a(paramIPage, "jstl")) && (paramIPage.exitsDesignFile("h_")))
    {
      localCTabItem1 = a(ResourceTools.getMessage("jstl.exportModel", "JSTL"), paramIPage.getEditUuid() + "jstl", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new ar(paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if ((a(paramIPage, "struts")) && (paramIPage.exitsDesignFile("s_")))
    {
      localCTabItem1 = a(ResourceTools.getMessage("struts.exportModel", "Struts"), paramIPage.getEditUuid() + "struts", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new com.flagleader.builder.a.d.be(paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if ((a(paramIPage, "bean")) && (paramIPage.exitsDesignFile("f_")))
    {
      localCTabItem1 = a(ResourceTools.getMessage("bean.exportModel", "Bean"), paramIPage.getEditUuid() + "form", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new com.flagleader.builder.a.d.al(paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if ((a(paramIPage, "action")) && (paramIPage.exitsDesignFile("a_")))
    {
      localCTabItem1 = a(ResourceTools.getMessage("action.exportModel", "Action"), paramIPage.getEditUuid() + "action", paramIPage);
      if ((localCTabItem1 != null) && (localCTabItem1.getControl() != null) && (localCTabItem1.getControl().getData() == null))
        localCTabItem1.getControl().setData(new C(paramIPage, (Composite)localCTabItem1.getControl(), this));
    }
    if (paramIPage.isDevelopModel())
      c(paramIPage);
  }

  public void h()
  {
    this.c = true;
    CTabItem[] arrayOfCTabItem = this.a.getItems();
    for (int i1 = arrayOfCTabItem.length - 1; i1 >= 0; i1--)
      arrayOfCTabItem[i1].dispose();
    if ((this.l != null) && (!this.l.isDisposed()) && (this.l.getControl() != null) && (!this.l.getControl().isDisposed()))
      this.l.getControl().dispose();
    this.c = false;
  }

  public BuilderManager i()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.bu
 * JD-Core Version:    0.6.0
 */