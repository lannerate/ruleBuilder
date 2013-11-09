package com.flagleader.builder.dialogs.d;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.xml.XmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class r extends com.flagleader.builder.dialogs.r
{
  private Iterator b = null;
  private List c = null;
  private ArrayList d = null;
  private com.flagleader.builder.widget.s e = new com.flagleader.builder.widget.s();
  TreeItem a;
  private Tree f;

  public r(Shell paramShell, Iterator paramIterator)
  {
    super(paramShell);
    this.b = paramIterator;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.InitJspFieldsDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(550, 350));
    this.f = this.e.a(localComposite2, 67618);
    this.f.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.InitJspFieldsDialog");
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".InitJspFieldsDialog");
      arrayOfInt[i] = 150;
      arrayOfString3[i] = "string";
    }
    this.e.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.f.setHeaderVisible(true);
    this.f.setLayoutData(new GridData(1808));
    this.a = new TreeItem(this.f, 0);
    a(this.a, ResourceTools.getMessage("fields.InitJspFieldsDialog"), "", "");
    while (this.b.hasNext())
    {
      Object localObject1 = this.b.next();
      Object localObject2;
      TreeItem localTreeItem;
      if ((localObject1 instanceof IVariableObject))
      {
        localObject2 = (IVariableObject)localObject1;
        localTreeItem = new TreeItem(this.a, 0);
        localTreeItem.setData(localObject2);
        a(localTreeItem, ((IVariableObject)localObject2).getDisplayName(), ((IVariableObject)localObject2).getValueName(), ((IVariableObject)localObject2).getValueType());
      }
      else if ((localObject1 instanceof ExcelBookModel))
      {
        localObject2 = (ExcelBookModel)localObject1;
        localTreeItem = new TreeItem(this.a, 0);
        localTreeItem.setData(localObject2);
        a(localTreeItem, ((ExcelBookModel)localObject2).getDisplayName(), ((ExcelBookModel)localObject2).getValueName(), ((ExcelBookModel)localObject2).getValueType());
      }
      else if ((localObject1 instanceof XmlNode))
      {
        localObject2 = (XmlNode)localObject1;
        localTreeItem = new TreeItem(this.a, 0);
        localTreeItem.setData(localObject2);
        a(localTreeItem, ((XmlNode)localObject2).getDisplayName(), ((XmlNode)localObject2).getValueName(), ((XmlNode)localObject2).getValueType());
      }
      else
      {
        if (!(localObject1 instanceof SheetTable))
          continue;
        localObject2 = (SheetTable)localObject1;
        localTreeItem = new TreeItem(this.a, 0);
        localTreeItem.setData(localObject2);
        a(localTreeItem, ((SheetTable)localObject2).getDisplayName(), ((SheetTable)localObject2).getValueName(), ((SheetTable)localObject2).getValueType());
      }
    }
    this.a.setExpanded(true);
    this.f.addSelectionListener(new s(this));
    for (int j = 0; j < this.f.getColumnCount(); j++)
      this.f.getColumn(j).pack();
    return (Control)localComposite1;
  }

  private void a(TreeItem paramTreeItem, String paramString1, String paramString2, String paramString3)
  {
    paramTreeItem.setText(0, paramString1);
    paramTreeItem.setText(1, paramString2);
    paramTreeItem.setText(2, paramString3);
  }

  protected void okPressed()
  {
    TreeItem[] arrayOfTreeItem = this.a.getItems();
    this.c = new ArrayList();
    this.d = new ArrayList();
    for (int i = 0; i < arrayOfTreeItem.length; i++)
      if (arrayOfTreeItem[i].getChecked())
        this.c.add(arrayOfTreeItem[i].getData());
      else
        this.d.add(arrayOfTreeItem[i].getData());
    super.okPressed();
  }

  public List a()
  {
    return this.c;
  }

  public List b()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.r
 * JD-Core Version:    0.6.0
 */