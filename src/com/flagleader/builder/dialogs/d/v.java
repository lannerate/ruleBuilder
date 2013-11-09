package com.flagleader.builder.dialogs.d;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestObjectInfo;
import java.util.List;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class v extends f
{
  private static final int a = 650;
  private static final int b = 400;
  private String[] c;
  private String[] d;
  private Table e;
  private TestCase f = null;
  private boolean g = false;
  private TableEditor h;
  private TableItem i;

  public v(TestCase paramTestCase)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = paramTestCase;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(new GridLayout());
    localComposite2.setLayoutData(new GridData(1808));
    d(localComposite2);
    b(localComposite1);
    return localComposite1;
  }

  private void d(Composite paramComposite)
  {
    e(paramComposite);
    b(this.e);
    a(this.e);
    this.h = new TableEditor(this.e);
    this.e.addKeyListener(new w(this));
    this.e.addMouseMoveListener(new x(this));
    this.e.addMouseListener(new y(this));
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(this.e.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.i, paramInt);
    paramText.addFocusListener(new z(this, paramText, paramTableItem, paramInt, paramTableEditor));
    paramText.addTraverseListener(new A(this, paramText, paramTableItem, paramInt, paramTableEditor));
  }

  private Table e(Composite paramComposite)
  {
    this.e = new Table(paramComposite, 67586);
    GridData localGridData = new GridData();
    localGridData.widthHint = 650;
    localGridData.heightHint = 400;
    this.e.setLayoutData(localGridData);
    this.e.setLinesVisible(true);
    return this.e;
  }

  private void a(Table paramTable)
  {
    if (this.f != null)
    {
      List localList = this.f.getChildrenList();
      for (int j = 0; j < localList.size(); j++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        TestObjectInfo localTestObjectInfo = (TestObjectInfo)localList.get(j);
        localTableItem.setText(new String[] { localTestObjectInfo.getDisplayName(), localTestObjectInfo.getInitialValue(), localTestObjectInfo.getExpectValue(), localTestObjectInfo.getType(), localTestObjectInfo.getAttributeName() });
        localTableItem.setData(localTestObjectInfo);
      }
    }
  }

  private void b(Table paramTable)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.TestCaseInfoDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.TestCaseInfoDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("types.TestCaseInfoDialog");
    for (int j = 0; j < arrayOfString1.length; j++)
    {
      arrayOfString3[j] = "string";
      TableColumn localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(ResourceTools.getMessage(arrayOfString1[j] + ".TestCaseInfoDialog"));
      localTableColumn.setWidth(Integer.parseInt(arrayOfString2[j]));
    }
  }

  private TableItem f()
  {
    if (this.e.getSelectionIndex() >= 0)
      return this.e.getSelection()[0];
    return null;
  }

  protected void okPressed()
  {
    if (!this.f.isLocked())
    {
      TableItem[] arrayOfTableItem = this.e.getItems();
      for (int j = 0; j < arrayOfTableItem.length; j++)
      {
        TestObjectInfo localTestObjectInfo = (TestObjectInfo)arrayOfTableItem[j].getData();
        localTestObjectInfo.setInitialValue(arrayOfTableItem[j].getText(1));
        localTestObjectInfo.setExpectValue(arrayOfTableItem[j].getText(2));
      }
    }
    close();
  }

  protected void a()
  {
    close();
  }

  public boolean b()
  {
    return this.e.getSelectionCount() > 0;
  }

  public boolean c()
  {
    return this.e.getSelectionCount() > 0;
  }

  public void d()
  {
    TableItem[] arrayOfTableItem = this.e.getSelection();
    for (int j = 0; j < arrayOfTableItem.length; j++)
      arrayOfTableItem[j].dispose();
    this.g = true;
  }

  public boolean e()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.v
 * JD-Core Version:    0.6.0
 */