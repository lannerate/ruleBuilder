package com.flagleader.builder.e.c;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.TableModel;
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

public class d extends WizardPage
{
  private Tree b;
  c a;
  private List c;
  private boolean d = false;

  public d(c paramc)
  {
    super("SelectModifyField");
    setTitle(a("title.SelectModifyFieldPage"));
    setDescription(a("describe.SelectModifyFieldPage"));
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
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SelectModifyFieldPage");
    while (this.b.getColumnCount() > 0)
      this.b.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".SelectModifyFieldPage");
    for (i = 0; i < arrayOfString2.length; i++)
    {
      TreeColumn localTreeColumn = new TreeColumn(this.b, 8388608);
      localTreeColumn.setText(arrayOfString2[i]);
      localTreeColumn.setWidth(150);
    }
    this.b.setLayoutData(new GridData(1808));
    this.b.addSelectionListener(new e(this));
    setControl(localComposite);
    for (i = 0; i < this.c.size(); i++)
      a((TableModel)this.c.get(i));
  }

  public void a(TableModel paramTableModel)
  {
    this.b.removeAll();
    TreeItem[] arrayOfTreeItem = this.b.getItems();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      if (paramTableModel.equals(arrayOfTreeItem[i].getData()))
        break;
    a(paramTableModel);
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

  private void d()
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

  public List b()
  {
    return this.c;
  }

  public void a(List paramList)
  {
    this.c = paramList;
  }

  public boolean c()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.c.d
 * JD-Core Version:    0.6.0
 */