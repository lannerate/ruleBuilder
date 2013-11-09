package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.tree.TestObjectInfo;
import java.util.ArrayList;
import java.util.List;
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

public class B extends aS
  implements IElementViewer
{
  private Table f;
  private TableItem g;
  private TableItem q;
  private TableEditor r;
  private int s = 0;
  int e = 0;
  private com.flagleader.manager.e.K t;

  public B(TestCaseLib paramTestCaseLib, Composite paramComposite, bu parambu)
  {
    super(paramTestCaseLib, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new B((TestCaseLib)this.c, paramComposite, this.a);
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
    this.f.addMouseListener(new I(this));
    return localComposite;
  }

  protected void h()
  {
    a(new E(this));
    a(new K(this));
    a(new G(this));
    a(new F(this));
    a(new H(this));
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
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText("");
    localTableColumn.setWidth(40);
    String[] arrayOfString = g().getVarnames();
    if (arrayOfString != null)
    {
      for (int i = 0; i < arrayOfString.length; i++)
      {
        localTableColumn = new TableColumn(this.f, 0);
        localTableColumn.setText(arrayOfString[i]);
        localTableColumn.setWidth(100);
      }
      this.s = arrayOfString.length;
    }
  }

  private void a(TableItem paramTableItem)
  {
    this.g = paramTableItem;
  }

  public void e()
  {
    this.e = 0;
    this.t = ((com.flagleader.manager.e.K)a().getRulesManager().l().a(g()));
    z();
    a(this.t.q(), false, true);
    C();
    a().getShell().setCursor(a().getShell().getDisplay().getSystemCursor(3));
    C localC = new C(this);
    Display.getCurrent().timerExec(100, localC);
  }

  public void f()
  {
    g().setModified(true);
    this.p = this.e;
    b(this.p);
    z();
    this.f.getDisplay().asyncExec(new D(this));
  }

  private void j()
  {
    this.f.removeAll();
    Control[] arrayOfControl = this.f.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    ArrayList localArrayList = g().getTestInfos();
    for (int j = 0; j < localArrayList.size(); j++)
    {
      TestCase localTestCase = (TestCase)localArrayList.get(j);
      TableItem localTableItem = new TableItem(this.f, 8);
      localTableItem.setData(localTestCase);
      localTableItem.setText(0, String.valueOf(j + 1));
      for (int k = 1; k < this.f.getColumnCount(); k++)
      {
        TestObjectInfo localTestObjectInfo = localTestCase.getMatchTestObjectInfo(this.f.getColumn(k).getText());
        if (localTestObjectInfo == null)
          continue;
        localTableItem.setText(k, localTestObjectInfo.getInitialValue());
      }
    }
    for (j = 1; j < this.f.getColumnCount(); j++)
      this.f.getColumn(j).pack();
  }

  public String getCompositeUuid()
  {
    return g().getEditUuid() + "init";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.B
 * JD-Core Version:    0.6.0
 */