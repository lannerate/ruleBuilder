package com.flagleader.builder.a.d;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.c;
import com.flagleader.export.PagesMessages;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class aI extends aS
  implements IElementViewer
{
  private Table e;

  public aI(IPage paramIPage, Composite paramComposite, bu parambu)
  {
    super(paramIPage, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new aI((IPage)this.c, paramComposite, this.a);
  }

  protected IPage e()
  {
    return (IPage)this.c;
  }

  protected void h()
  {
    a(new aR(this));
    a(new aQ(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "moveUp");
    a(paramToolBar, "moveDown");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "cut");
    a(paramToolBar, "copy");
    a(paramToolBar, "paste");
    a(paramToolBar, "delete");
    a(paramToolBar, "selectall");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    return localComposite;
  }

  private void f()
  {
    int i = this.e.getSelectionIndex();
    if ((i > 0) && (this.e.getItemCount() > 1))
    {
      TableItem localTableItem1 = this.e.getItem(i - 1);
      String str1 = localTableItem1.getText(0);
      String str2 = localTableItem1.getText(1);
      String str3 = localTableItem1.getText(2);
      localTableItem1.setText(new String[] { this.e.getItem(i).getText(0), this.e.getItem(i).getText(1), this.e.getItem(i).getText(2) });
      TableItem localTableItem2 = this.e.getItem(i);
      Object localObject1 = localTableItem1.getData();
      localTableItem1.setData(localTableItem2.getData());
      localTableItem2.setText(new String[] { str1, str2, str3 });
      localTableItem2.setData(localObject1);
      this.e.update();
      this.e.setSelection(i - 1);
      Object localObject2 = e().getPropertiesList().remove(i);
      e().getPropertiesList().add(i - 1, localObject2);
      e().setModified(true);
    }
  }

  private void g()
  {
    int i = this.e.getSelectionIndex();
    if ((i > -1) && (this.e.getItemCount() > 1) && (i < this.e.getItemCount() - 1))
    {
      TableItem localTableItem1 = this.e.getItem(i + 1);
      String str1 = localTableItem1.getText(0);
      String str2 = localTableItem1.getText(1);
      String str3 = localTableItem1.getText(2);
      localTableItem1.setText(new String[] { this.e.getItem(i).getText(0), this.e.getItem(i).getText(1), this.e.getItem(i).getText(2) });
      TableItem localTableItem2 = this.e.getItem(i);
      Object localObject1 = localTableItem1.getData();
      localTableItem1.setData(localTableItem2.getData());
      localTableItem2.setText(new String[] { str1, str2, str3 });
      localTableItem2.setData(localObject1);
      this.e.update();
      this.e.setSelection(i + 1);
      Object localObject2 = e().getPropertiesList().remove(i);
      e().getPropertiesList().add(i + 1, localObject2);
      e().setModified(true);
    }
  }

  private void b(Composite paramComposite)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = e().getPreferences().getStringArray(e().getImportFile() + ".keys");
    if (arrayOfString1 == null)
      arrayOfString1 = e().getPreferences().getStringArray("export.keys");
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = e().getPreferences().getString(arrayOfString1[i] + ".kvalue", arrayOfString1[i]);
    if ((arrayOfString1 != null) && (arrayOfString2 != null))
      for (i = 0; (i < arrayOfString1.length) && (i < arrayOfString2.length); i++)
        localHashMap.put(arrayOfString1[i], arrayOfString2[i]);
    f(paramComposite);
    a(this.e);
    if (b())
      return;
    this.e.addKeyListener(new aJ(this));
    this.e.addMouseMoveListener(new aK(this));
    this.e.addMouseListener(new aL(this));
  }

  private Table f(Composite paramComposite)
  {
    this.e = new Table(paramComposite, 67586);
    this.e.setLayoutData(new GridData(1808));
    this.e.setLinesVisible(true);
    return this.e;
  }

  private void i()
  {
    this.e.removeAll();
    Control[] arrayOfControl = this.e.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = e().getPreferences().getStringArray(e().getImportFile() + ".keys");
    if (arrayOfString1 == null)
      arrayOfString1 = e().getPreferences().getStringArray("export.keys");
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int j = 0; j < arrayOfString1.length; j++)
      arrayOfString2[j] = e().getPreferences().getString(arrayOfString1[j] + ".kvalue", arrayOfString1[j]);
    for (j = 0; (arrayOfString1 != null) && (arrayOfString2 != null) && (j < arrayOfString1.length); j++)
      localHashMap.put(arrayOfString1[j], arrayOfString2[j]);
    List localList = e().getPropertiesList();
    if ((localList != null) && (localList.size() > 0))
      for (int k = 0; k < localList.size(); k++)
      {
        AdvancedProperty localAdvancedProperty = (AdvancedProperty)localList.get(k);
        TableItem localTableItem = new TableItem(this.e, 0);
        localTableItem.setData(localAdvancedProperty);
        String str = "";
        if (e().getPreferences().getString(localAdvancedProperty.getKey() + ".display") != null)
          str = e().getPreferences().getString(localAdvancedProperty.getKey() + ".display");
        for (int m = 0; (arrayOfString1 != null) && (arrayOfString2 != null) && (m < arrayOfString1.length); m++)
        {
          if (!localAdvancedProperty.getKey().startsWith(arrayOfString1[m]))
            continue;
          str = arrayOfString2[m];
          break;
        }
        localTableItem.setText(new String[] { localAdvancedProperty.getKey(), localAdvancedProperty.getProperty(), str });
      }
  }

  private void a(Table paramTable)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(ResourceTools.getMessage("key.ExportDialog"));
    localTableColumn.setWidth(180);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(ResourceTools.getMessage("value.ExportDialog"));
    localTableColumn.setWidth(185);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(ResourceTools.getMessage("describe.DataDialog"));
    localTableColumn.setWidth(185);
  }

  private TableItem j()
  {
    if (this.e.getSelectionIndex() >= 0)
      return this.e.getSelection()[0];
    return null;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    i();
    super.update();
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "props";
  }

  public boolean canCopy()
  {
    return (this.e.isFocusControl()) && (this.e.getSelectionCount() > 0);
  }

  public boolean canCut()
  {
    return (this.e.isFocusControl()) && (this.e.getSelectionCount() > 0);
  }

  public boolean canDelete()
  {
    return (this.e.isFocusControl()) && (this.e.getSelectionCount() > 0);
  }

  public boolean canPaste()
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(c.a());
    if (localObject == null)
      return false;
    if ((localObject instanceof AdvancedProperty))
      return true;
    if ((localObject instanceof ArrayList))
    {
      ArrayList localArrayList = (ArrayList)localObject;
      for (int i = 0; i < localArrayList.size(); i++)
        if ((localArrayList.get(i) instanceof AdvancedProperty))
          return true;
    }
    return false;
  }

  public void copy()
  {
    ArrayList localArrayList = new ArrayList();
    TableItem[] arrayOfTableItem = this.e.getSelection();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof AdvancedProperty)))
        continue;
      localArrayList.add(arrayOfTableItem[i].getData());
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localArrayList }, new Transfer[] { c.a() });
  }

  public void cut()
  {
    ArrayList localArrayList = new ArrayList();
    TableItem[] arrayOfTableItem = this.e.getSelection();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof AdvancedProperty)))
        continue;
      localArrayList.add(arrayOfTableItem[i].getData());
      e().getPropertiesList().remove(arrayOfTableItem[i].getData());
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localArrayList }, new Transfer[] { c.a() });
    e().setModified(true);
    update();
  }

  public void delete()
  {
    TableItem[] arrayOfTableItem = this.e.getSelection();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof AdvancedProperty)))
        continue;
      e().getPropertiesList().remove(arrayOfTableItem[i].getData());
    }
    e().setModified(true);
    update();
  }

  public boolean paste()
  {
    Object localObject = new Clipboard(Display.getCurrent()).getContents(c.a());
    if (localObject != null)
    {
      if ((localObject instanceof AdvancedProperty))
      {
        e().getPropertiesList().add(localObject);
        e().setModified(true);
        update();
        return true;
      }
      if ((localObject instanceof ArrayList))
      {
        ArrayList localArrayList = (ArrayList)localObject;
        for (int i = 0; i < localArrayList.size(); i++)
        {
          if (!(localArrayList.get(i) instanceof AdvancedProperty))
            continue;
          e().getPropertiesList().add(localArrayList.get(i));
          e().setModified(true);
        }
        update();
        return true;
      }
    }
    return false;
  }

  public void selectAll()
  {
    this.e.selectAll();
    setChanged();
    notifyObservers();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aI
 * JD-Core Version:    0.6.0
 */