package com.flagleader.builder.e.d;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class f extends WizardPage
{
  private Tree b;
  private boolean c = false;
  c a;

  public f(c paramc)
  {
    super("SelectField");
    setTitle(a("title.SelectWherePage"));
    setDescription(a("describe.SelectWherePage"));
    this.a = paramc;
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
    this.b = new Tree(localComposite, 67618);
    this.b.setLayoutData(new GridData(1808));
    this.b.setHeaderVisible(true);
    this.b.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SelectWherePage");
    while (this.b.getColumnCount() > 0)
      this.b.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".SelectWherePage");
    for (i = 0; i < arrayOfString2.length; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.b, 8388608);
      localTreeColumn.setText(arrayOfString2[i]);
      localTreeColumn.setWidth(150);
    }
    this.b.setLayoutData(new GridData(1808));
    this.b.addSelectionListener(new g(this));
    setControl(localComposite);
    a(this.a.l());
  }

  private void a(ISelectObject paramISelectObject)
  {
    TreeItem localTreeItem1 = new TreeItem(this.b, 0);
    localTreeItem1.setText(0, paramISelectObject.getDisplayName());
    localTreeItem1.setData(paramISelectObject);
    List localList = paramISelectObject.getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      FieldModel localFieldModel = (FieldModel)localList.get(i);
      TreeItem localTreeItem2 = new TreeItem(localTreeItem1, 0);
      localTreeItem2.setData(localFieldModel);
      localTreeItem2.setText(0, localFieldModel.getDisplayName());
      localTreeItem2.setText(1, localFieldModel.getFieldName());
      localTreeItem2.setText(2, localFieldModel.getValueType());
    }
    localTreeItem1.setExpanded(true);
  }

  public void a(TableModel paramTableModel)
  {
    this.b.removeAll();
    TreeItem[] arrayOfTreeItem = this.b.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      if (paramTableModel.equals(arrayOfTreeItem[i].getData()))
        break;
    a(paramTableModel);
    List localList = paramTableModel.getFields();
    for (int j = 0; j < localList.size(); j++)
    {
      FieldModel localFieldModel = (FieldModel)localList.get(j);
      if (!localFieldModel.isFriendKey())
        continue;
      FKModel localFKModel = this.a.a().getFKModel(paramTableModel.getTableName(), localFieldModel.getFieldName());
      if (localFKModel == null)
        continue;
      String str1 = localFKModel.getPkTableName();
      String str2 = ((AdvancedProperty)localFKModel.getKeys().get(0)).getKey();
      TableModel localTableModel = this.a.a().getTableModel(str1);
      if (localTableModel == null)
        continue;
      arrayOfTreeItem = this.b.getItems();
      for (int k = 0; k < arrayOfTreeItem.length; k++)
        if (localTableModel.equals(arrayOfTreeItem[k].getData()))
          break;
      a(localTableModel);
    }
  }

  public void b(TableModel paramTableModel)
  {
    TreeItem[] arrayOfTreeItem = this.b.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
    {
      if (!paramTableModel.equals(arrayOfTreeItem[i].getData()))
        continue;
      arrayOfTreeItem[i].dispose();
    }
  }

  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    TreeItem[] arrayOfTreeItem1 = this.b.getItems();
    localArrayList.clear();
    for (int i = 0; i < arrayOfTreeItem1.length; i++)
    {
      if (!(arrayOfTreeItem1[i].getData() instanceof ISelectObject))
        continue;
      TreeItem[] arrayOfTreeItem2 = arrayOfTreeItem1[i].getItems();
      for (int j = 0; j < arrayOfTreeItem2.length; j++)
      {
        if ((!arrayOfTreeItem2[j].getChecked()) || (!(arrayOfTreeItem2[j].getData() instanceof FieldModel)))
          continue;
        localArrayList.add(arrayOfTreeItem2[j].getData());
      }
    }
    return localArrayList;
  }

  private void c()
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

  public boolean b()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.d.f
 * JD-Core Version:    0.6.0
 */