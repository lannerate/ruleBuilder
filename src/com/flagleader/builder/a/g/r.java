package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.e.K;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.tree.TestObjectInfo;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

public class r extends aS
  implements IElementViewer
{
  private Table g;
  private TableItem q;
  private TableItem r;
  private TableEditor s;
  private int t = 0;
  int e = 0;
  private String[] u;
  private int[] v;
  Map f;
  private K w;

  public r(TestCaseLib paramTestCaseLib, Composite paramComposite, bu parambu)
  {
    super(paramTestCaseLib, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new r((TestCaseLib)this.c, paramComposite, this.a);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.g = new Table(localComposite, 65536);
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    this.g.setLayoutData(localGridData);
    this.g.setHeaderVisible(true);
    this.g.setLinesVisible(true);
    i();
    this.g.setVisible(true);
    this.g.addMouseListener(new y(this));
    return localComposite;
  }

  protected void h()
  {
    a(new u(this));
    a(new A(this));
    a(new w(this));
    a(new v(this));
    a(new x(this));
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

  private TestCaseLib g()
  {
    return (TestCaseLib)this.c;
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
    while (this.g.getColumnCount() > 0)
      this.g.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.g, 0);
    localTableColumn.setText("");
    localTableColumn.setWidth(40);
    this.u = g().getVarnames();
    if (this.u != null)
    {
      this.v = new int[this.u.length];
      for (int i = 0; i < this.u.length; i++)
      {
        localTableColumn = new TableColumn(this.g, 0);
        localTableColumn.setText(this.u[i]);
        localTableColumn.setWidth(100);
        localTableColumn = new TableColumn(this.g, 0);
        localTableColumn.setText(" ");
        localTableColumn.setWidth(100);
        int j = g().getVarinout(this.u[i]);
        this.v[i] = j;
        if (j != 3)
          continue;
        localTableColumn = new TableColumn(this.g, 0);
        localTableColumn.setText(" ");
        localTableColumn.setWidth(100);
      }
      this.t = this.u.length;
    }
    this.f = g().getCheckRuleName();
    if (this.f != null)
    {
      Iterator localIterator = this.f.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = String.valueOf(localIterator.next());
        localTableColumn = new TableColumn(this.g, 0);
        localTableColumn.setText(String.valueOf(str));
        localTableColumn.setWidth(100);
        localTableColumn = new TableColumn(this.g, 0);
        localTableColumn.setText(" ");
        localTableColumn.setWidth(100);
      }
    }
  }

  private void a(TableItem paramTableItem)
  {
    this.q = paramTableItem;
  }

  public void e()
  {
    this.e = 0;
    this.w = ((K)a().getRulesManager().l().a(g()));
    z();
    a(this.w.q(), false, true);
    C();
    a().getShell().setCursor(a().getShell().getDisplay().getSystemCursor(3));
    s locals = new s(this);
    Display.getCurrent().timerExec(100, locals);
  }

  public void f()
  {
    g().setModified(true);
    this.p = this.e;
    b(this.p);
    z();
    this.g.getDisplay().asyncExec(new t(this));
  }

  private void j()
  {
    this.g.removeAll();
    Control[] arrayOfControl = this.g.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    i = 0;
    TableItem localTableItem1 = new TableItem(this.g, 8);
    localTableItem1.setText(i++, "");
    for (int j = 0; j < this.u.length; j++)
    {
      k = g().getVarinout(this.u[j]);
      if ((k == 1) || (k == 3))
        localTableItem1.setText(i++, ResourceTools.getMessage("input.TestCaseLibEditor"));
      if ((k == 2) || (k == 3))
        localTableItem1.setText(i++, ResourceTools.getMessage("will.TestCaseLibEditor"));
      localTableItem1.setText(i++, ResourceTools.getMessage("result.TestCaseLibEditor"));
    }
    if ((this.f != null) && (this.f.size() > 0))
      for (j = 0; j < this.f.size(); j++)
      {
        localTableItem1.setText(i++, ResourceTools.getMessage("matchnum.TestCaseLibEditor"));
        localTableItem1.setText(i++, ResourceTools.getMessage("matchrule.TestCaseLibEditor"));
      }
    ArrayList localArrayList = g().getTestInfos();
    for (int k = 0; k < localArrayList.size(); k++)
    {
      TestCase localTestCase = (TestCase)localArrayList.get(k);
      TableItem localTableItem2 = new TableItem(this.g, 8);
      localTableItem2.setData(localTestCase);
      localTableItem2.setText(0, String.valueOf(k + 1));
      int m = 1;
      for (int n = 0; n < this.t; n++)
      {
        localObject = localTestCase.getMatchTestObjectInfo(this.u[n]);
        if (localObject == null)
          continue;
        int i1 = this.v[n];
        if ((i1 == 1) || (i1 == 3))
          localTableItem2.setText(m++, ((TestObjectInfo)localObject).getInitialValue());
        if ((i1 == 2) || (i1 == 3))
          localTableItem2.setText(m++, ((TestObjectInfo)localObject).getExpectValue());
        if ((((TestObjectInfo)localObject).isOutVariable()) && (((TestObjectInfo)localObject).isChanged()))
        {
          localTableItem2.setForeground(m, h.g);
          localTableItem2.setForeground(0, h.g);
        }
        localTableItem2.setText(m++, StringUtil.stringValue(((TestObjectInfo)localObject).getResultValue()));
      }
      if ((this.f == null) || (this.f.size() <= 0))
        continue;
      Map localMap = localTestCase.getCheckRuleMap();
      Object localObject = this.f.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = String.valueOf(((Iterator)localObject).next());
        int i2 = NumberUtil.getInt(this.f.get(str));
        List localList = (List)localMap.get(String.valueOf(str));
        if ((localList != null) && (localList.size() > 0))
        {
          if ((i2 == 2) && (localList.size() > 1))
            localTableItem2.setForeground(m, h.g);
          localTableItem2.setText(m++, StringUtil.stringValue(localList.size()));
          localTableItem2.setText(m++, StringUtil.stringValue(localList));
        }
        else
        {
          if (i2 == 1)
            localTableItem2.setForeground(m, h.g);
          localTableItem2.setText(m++, "0");
          localTableItem2.setText(m++, "");
        }
      }
    }
    for (k = 1; k < this.g.getColumnCount(); k++)
      this.g.getColumn(k).pack();
  }

  public String getCompositeUuid()
  {
    return g().getEditUuid() + "test";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.r
 * JD-Core Version:    0.6.0
 */