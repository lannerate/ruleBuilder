package com.flagleader.builder.e.i;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.TableModel;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class h extends WizardPage
{
  private TableTree a;

  public h()
  {
    super("SelectWhere");
    setTitle(a("title.SelectWherePage"));
    setDescription(a("describe.SelectWherePage"));
  }

  public void createControl(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(1));
    localComposite.setLayoutData(a(550, 400));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite.setLayout(localGridLayout);
    this.a = new TableTree(localComposite, 67618);
    this.a.setLayoutData(new GridData(1808));
    this.a.getTable().setHeaderVisible(true);
    this.a.getTable().setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SelectWherePage");
    while (this.a.getTable().getColumnCount() > 0)
      this.a.getTable().getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".SelectWherePage");
    for (i = 0; i < arrayOfString2.length; i++)
    {
      TableColumn localTableColumn = new TableColumn(this.a.getTable(), 8388608);
      localTableColumn.setText(arrayOfString2[i]);
      localTableColumn.setWidth(150);
    }
    this.a.setLayoutData(new GridData(1808));
    this.a.addSelectionListener(new i(this));
    setControl(localComposite);
  }

  public void a(TableModel paramTableModel)
  {
    TableTreeItem[] arrayOfTableTreeItem = this.a.getItems();
    for (int i = 0; i < arrayOfTableTreeItem.length; i++)
      if (paramTableModel.equals(arrayOfTableTreeItem[i].getData()))
        return;
    a(paramTableModel);
  }

  public void b(TableModel paramTableModel)
  {
    TableTreeItem[] arrayOfTableTreeItem = this.a.getItems();
    for (int i = 0; i < arrayOfTableTreeItem.length; i++)
    {
      if (!paramTableModel.equals(arrayOfTableTreeItem[i].getData()))
        continue;
      arrayOfTableTreeItem[i].dispose();
    }
  }

  private void a(ISelectObject paramISelectObject)
  {
    TableTreeItem localTableTreeItem1 = new TableTreeItem(this.a, 0);
    localTableTreeItem1.setText(0, paramISelectObject.getDisplayName());
    localTableTreeItem1.setData(paramISelectObject);
    List localList = paramISelectObject.getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      FieldModel localFieldModel = (FieldModel)localList.get(i);
      TableTreeItem localTableTreeItem2 = new TableTreeItem(localTableTreeItem1, 0);
      localTableTreeItem2.setData(localFieldModel);
      localTableTreeItem2.setText(0, localFieldModel.getDisplayName());
      localTableTreeItem2.setText(1, localFieldModel.getFieldName());
      localTableTreeItem2.setText(2, localFieldModel.getValueType());
    }
    localTableTreeItem1.setExpanded(true);
  }

  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    TableTreeItem[] arrayOfTableTreeItem1 = this.a.getItems();
    localArrayList.clear();
    for (int i = 0; i < arrayOfTableTreeItem1.length; i++)
    {
      if (!(arrayOfTableTreeItem1[i].getData() instanceof ISelectObject))
        continue;
      TableTreeItem[] arrayOfTableTreeItem2 = arrayOfTableTreeItem1[i].getItems();
      for (int j = 0; j < arrayOfTableTreeItem2.length; j++)
      {
        if ((!arrayOfTableTreeItem2[j].getChecked()) || (!(arrayOfTableTreeItem2[j].getData() instanceof FieldModel)))
          continue;
        localArrayList.add(arrayOfTableTreeItem2[j].getData());
      }
    }
    return localArrayList;
  }

  private void b()
  {
    b(null);
  }

  private void b(String paramString)
  {
    setErrorMessage(paramString);
    setPageComplete(paramString == null);
  }

  protected GridLayout a(int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    return localGridLayout;
  }

  protected String a(String paramString)
  {
    return ResourceTools.getMessage(paramString);
  }

  protected GridData a(int paramInt1, int paramInt2)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt1;
    localGridData.heightHint = paramInt2;
    return localGridData;
  }

  private void a(Composite paramComposite, int paramInt)
  {
    Label localLabel = new Label(paramComposite, 259);
    GridData localGridData = new GridData(768);
    localGridData.horizontalSpan = paramInt;
    localLabel.setLayoutData(localGridData);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.i.h
 * JD-Core Version:    0.6.0
 */