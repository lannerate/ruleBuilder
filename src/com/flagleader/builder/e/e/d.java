package com.flagleader.builder.e.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class d extends WizardPage
{
  c a = null;
  private i c = new i(false, true);
  private Table d;
  private List e = null;
  private ISelection f;
  List b = new ArrayList();

  public d(c paramc)
  {
    super("SelectTable");
    setTitle(a("title.SelectTablePage"));
    setDescription(a("describe.SelectTablePage"));
    this.a = paramc;
    this.e = paramc.a().getTables();
  }

  public void createControl(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(1));
    localComposite.setLayoutData(a(550, 400));
    this.d = this.c.a(localComposite, 67618);
    this.d.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SelectTablePage");
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".SelectTablePage");
      arrayOfInt[i] = 150;
      arrayOfString3[i] = "string";
    }
    this.c.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.d.setHeaderVisible(true);
    this.d.setLayoutData(new GridData(1808));
    for (i = 0; i < this.e.size(); i++)
    {
      TableItem localTableItem = new TableItem(this.d, 0);
      TableModel localTableModel = (TableModel)this.e.get(i);
      localTableItem.setData(localTableModel);
      a(localTableItem, localTableModel.getTableName(), localTableModel.getDisplayName(), a(localTableModel));
    }
    this.d.addSelectionListener(new e(this));
    setControl(localComposite);
  }

  private String a(TableModel paramTableModel)
  {
    if (paramTableModel.getFields().size() < 1)
      return "";
    String str = "";
    for (int i = 0; i < paramTableModel.getFields().size(); i++)
      str = str + ((FieldModel)paramTableModel.getFields().get(i)).getDisplayName() + "   ";
    return str;
  }

  private void a(TableItem paramTableItem, String paramString1, String paramString2, String paramString3)
  {
    paramTableItem.setText(0, paramString1);
    paramTableItem.setText(1, paramString2);
    paramTableItem.setText(2, paramString3);
  }

  public List a()
  {
    return this.b;
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
 * Qualified Name:     com.flagleader.builder.e.e.d
 * JD-Core Version:    0.6.0
 */