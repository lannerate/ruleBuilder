package com.flagleader.builder.a.g;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.tree.TestObjectInfo;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;

public class L extends aS
  implements IElementViewer
{
  private Table f;
  private TableItem g;
  private TableItem q;
  private TableEditor r;
  private int s = 7;
  int e = 0;

  public L(TestCaseLib paramTestCaseLib, Composite paramComposite, bu parambu)
  {
    super(paramTestCaseLib, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new L((TestCaseLib)this.c, paramComposite, this.a);
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
    f();
    this.f.setVisible(true);
    this.f.addMouseListener(new M(this));
    return localComposite;
  }

  protected void h()
  {
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    super.a(paramToolBar);
  }

  private TestCaseLib e()
  {
    return (TestCaseLib)this.c;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    f();
    g();
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.c.getMaxModifyTime());
  }

  private void f()
  {
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText("");
    localTableColumn.setWidth(40);
    String[] arrayOfString = e().getVarnames();
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

  private void g()
  {
    this.f.removeAll();
    Control[] arrayOfControl = this.f.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    ArrayList localArrayList = e().getTestInfos();
    for (int j = 0; j < localArrayList.size(); j++)
    {
      TestCase localTestCase = (TestCase)localArrayList.get(j);
      TableItem localTableItem = new TableItem(this.f, 8);
      localTableItem.setText(0, String.valueOf(j + 1));
      localTableItem.setData(localTestCase);
      int k = 0;
      for (int m = 1; m < this.f.getColumnCount(); m++)
      {
        TestObjectInfo localTestObjectInfo = localTestCase.getMatchTestObjectInfo(this.f.getColumn(m).getText());
        if (localTestObjectInfo == null)
          continue;
        localTableItem.setText(m, StringUtil.stringValue(localTestObjectInfo.getResultValue()));
        if ((!localTestObjectInfo.isOutVariable()) || (!localTestObjectInfo.isChanged()))
          continue;
        localTableItem.setForeground(m, h.g);
        k = 1;
      }
      if (k == 0)
        continue;
      localTableItem.setForeground(0, h.g);
    }
    for (j = 1; j < this.f.getColumnCount(); j++)
      this.f.getColumn(j).pack();
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "result";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.L
 * JD-Core Version:    0.6.0
 */