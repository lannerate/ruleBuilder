package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.e.N;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestObjectInfo;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class a extends aS
  implements IElementViewer
{
  private Table f;
  private TableItem g;
  private TableItem q;
  private TableEditor r;
  private int s = 0;
  int e = 0;
  private String[] t;
  private int[] u;
  private N v;
  private CheckRuleInfo w;

  public a(IRuleSet paramIRuleSet, Composite paramComposite, bu parambu)
  {
    super(paramIRuleSet, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new a((IRuleSet)this.c, paramComposite, this.a);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.f = new Table(localComposite, 65536);
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    this.f.setLayoutData(localGridData);
    this.f.setHeaderVisible(true);
    this.f.setLinesVisible(true);
    i();
    this.f.setVisible(true);
    this.f.addMouseListener(new h(this));
    return localComposite;
  }

  protected void h()
  {
    a(new d(this));
    a(new j(this));
    a(new f(this));
    a(new e(this));
    a(new g(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "add");
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "go");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "import");
    a(paramToolBar, "export");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  private IRuleSet g()
  {
    return (IRuleSet)this.c;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    i();
    j();
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.c.getMaxModifyTime());
  }

  private void i()
  {
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText("");
    localTableColumn.setWidth(40);
    this.t = k().getVarnames();
    if (this.t != null)
    {
      this.u = new int[this.t.length];
      for (int i = 0; i < this.t.length; i++)
      {
        localTableColumn = new TableColumn(this.f, 0);
        localTableColumn.setText(this.t[i]);
        localTableColumn.setWidth(100);
        localTableColumn = new TableColumn(this.f, 0);
        localTableColumn.setText(" ");
        localTableColumn.setWidth(100);
        int j = k().getVarinout(this.t[i]);
        this.u[i] = j;
        if (j != 3)
          continue;
        localTableColumn = new TableColumn(this.f, 0);
        localTableColumn.setText(" ");
        localTableColumn.setWidth(100);
      }
      this.s = this.t.length;
    }
    if (g().needCheckSubRule())
    {
      localTableColumn = new TableColumn(this.f, 0);
      localTableColumn.setText(String.valueOf(g().getDisplayName()));
      localTableColumn.setWidth(100);
      localTableColumn = new TableColumn(this.f, 0);
      localTableColumn.setText(" ");
      localTableColumn.setWidth(100);
    }
  }

  private void a(TableItem paramTableItem)
  {
    this.g = paramTableItem;
  }

  public void e()
  {
    this.e = 0;
    this.v = ((N)a().getRulesManager().l().a(k()));
    z();
    a(this.v.q(), false, true);
    C();
    a().getShell().setCursor(a().getShell().getDisplay().getSystemCursor(3));
    b localb = new b(this);
    Display.getCurrent().timerExec(100, localb);
  }

  public void f()
  {
    g().setModified(true);
    this.p = this.e;
    b(this.p);
    z();
    this.f.getDisplay().asyncExec(new c(this));
  }

  private void j()
  {
    this.f.removeAll();
    Control[] arrayOfControl = this.f.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    i = 0;
    TableItem localTableItem1 = new TableItem(this.f, 8);
    localTableItem1.setText(i++, "");
    for (int j = 0; j < this.t.length; j++)
    {
      k = k().getVarinout(this.t[j]);
      if ((k == 1) || (k == 3))
        localTableItem1.setText(i++, ResourceTools.getMessage("input.TestCaseLibEditor"));
      if ((k == 2) || (k == 3))
        localTableItem1.setText(i++, ResourceTools.getMessage("will.TestCaseLibEditor"));
      localTableItem1.setText(i++, ResourceTools.getMessage("result.TestCaseLibEditor"));
    }
    if (g().needCheckSubRule())
    {
      localTableItem1.setText(i++, ResourceTools.getMessage("matchnum.TestCaseLibEditor"));
      localTableItem1.setText(i++, ResourceTools.getMessage("matchrule.TestCaseLibEditor"));
    }
    ArrayList localArrayList = k().getTestInfos();
    for (int k = 0; k < localArrayList.size(); k++)
    {
      TestCase localTestCase = (TestCase)localArrayList.get(k);
      TableItem localTableItem2 = new TableItem(this.f, 8);
      localTableItem2.setData(localTestCase);
      localTableItem2.setText(0, String.valueOf(k + 1));
      int m = 1;
      for (int n = 0; n < this.s; n++)
      {
        localObject = localTestCase.getMatchTestObjectInfo(this.t[n]);
        if (localObject == null)
          continue;
        int i1 = this.u[n];
        if ((i1 == 1) || (i1 == 3))
          localTableItem2.setText(m++, ((TestObjectInfo)localObject).getInitialValue());
        if ((i1 == 2) || (i1 == 3))
          localTableItem2.setText(m++, ((TestObjectInfo)localObject).getExpectValue());
        if ((((TestObjectInfo)localObject).isOutVariable()) && (((TestObjectInfo)localObject).isChanged()))
        {
          localTableItem2.setForeground(m, com.flagleader.builder.widget.h.g);
          localTableItem2.setForeground(0, com.flagleader.builder.widget.h.g);
        }
        localTableItem2.setText(m++, StringUtil.stringValue(((TestObjectInfo)localObject).getResultValue()));
      }
      if (!g().needCheckSubRule())
        continue;
      Map localMap = localTestCase.getCheckRuleMap();
      Object localObject = (List)localMap.get(g().getDisplayName());
      if (localObject != null)
      {
        if ((g().getChecktype() == 2) && (((List)localObject).size() > 1))
          localTableItem2.setForeground(m, com.flagleader.builder.widget.h.g);
        localTableItem2.setText(m++, StringUtil.stringValue(((List)localObject).size()));
        localTableItem2.setText(m++, StringUtil.stringValue(localObject));
      }
      else
      {
        if (g().getChecktype() == 1)
          localTableItem2.setForeground(m, com.flagleader.builder.widget.h.g);
        localTableItem2.setText(m++, "0");
        localTableItem2.setText(m++, "");
      }
    }
    for (k = 1; k < this.f.getColumnCount(); k++)
      this.f.getColumn(k).pack();
  }

  public String getCompositeUuid()
  {
    return g().getEditUuid() + "batch";
  }

  private CheckRuleInfo k()
  {
    if (this.w == null)
      this.w = g().getCheckRuleInfo();
    return this.w;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.a
 * JD-Core Version:    0.6.0
 */