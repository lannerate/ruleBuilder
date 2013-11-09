package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.a.c.c;
import com.flagleader.builder.widget.d;
import com.flagleader.export.PagesMessages;
import com.flagleader.manager.r;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageElementModel;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.ExportModel;
import java.util.Iterator;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class P extends a
  implements IElementViewer
{
  private static final String f = "columns.JspElementEditor";
  private String[] g;
  private String[] q;

  public P(IPage paramIPage, Composite paramComposite, bu parambu)
  {
    super(paramIPage, paramComposite, parambu);
    this.q = paramIPage.getPreferences().getStringArray("elementType.choise");
    this.g = new String[this.q.length];
    for (int i = 0; i < this.q.length; i++)
      this.g[i] = paramIPage.getPreferences().getString(this.q[i] + ".NAME", "");
  }

  protected aS e(Composite paramComposite)
  {
    return new P((ExportModel)this.c, paramComposite, this.a);
  }

  protected IPage q()
  {
    return (IPage)this.c;
  }

  protected boolean a(int paramInt)
  {
    return paramInt < this.q.length;
  }

  protected String a(String paramString)
  {
    return q().getPreferences().getString(paramString + ".NAME", "");
  }

  protected void h()
  {
    a(new U(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "add");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  public void n()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.JspElementEditor");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.JspElementEditor");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      TableColumn localTableColumn = new TableColumn(this.e, 8388608);
      localTableColumn.setText(ResourceTools.getMessage(arrayOfString1[i] + ".JspElementEditor"));
      localTableColumn.setWidth(Integer.parseInt(arrayOfString2[i]));
    }
  }

  protected void a(Item paramItem, IElement paramIElement)
  {
    if ((paramIElement instanceof PageElementModel))
    {
      a(paramItem, false, a((PageElementModel)paramIElement));
      Iterator localIterator = ((PageElementModel)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof PageElementModel))
          continue;
        PageElementModel localPageElementModel = (PageElementModel)localObject;
        Item localItem = d(paramItem);
        localItem.setData(localPageElementModel);
        a(localItem, localPageElementModel);
      }
      b(paramItem);
    }
  }

  protected void p()
  {
    PageElementModel[] arrayOfPageElementModel = (PageElementModel[])q().getPageElements();
    for (int i = 0; (arrayOfPageElementModel != null) && (i < arrayOfPageElementModel.length); i++)
    {
      PageElementModel localPageElementModel = arrayOfPageElementModel[i];
      Item localItem = d(null);
      localItem.setData(localPageElementModel);
      a(localItem, localPageElementModel);
    }
    for (i = 2; i < this.e.getColumnCount(); i++)
      this.e.getColumns()[i].pack();
  }

  protected String[] k()
  {
    return ResourceTools.getStringArray("lengths.JspElementEditor");
  }

  protected String[] j()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.JspElementEditor");
    for (int i = 0; i < arrayOfString.length; i++)
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".JspElementEditor");
    return arrayOfString;
  }

  protected String[] a(PageElementModel paramPageElementModel)
  {
    String[] arrayOfString = new String[3];
    String str = "{";
    AdvancedProperty[] arrayOfAdvancedProperty = paramPageElementModel.getAdvanceProperties();
    for (int i = 0; i < arrayOfAdvancedProperty.length; i++)
      str = str + arrayOfAdvancedProperty[i].toString() + ",";
    str = str + "}";
    arrayOfString[0] = c(paramPageElementModel.getElementType());
    arrayOfString[1] = paramPageElementModel.getDisplayName();
    arrayOfString[2] = str;
    return arrayOfString;
  }

  private String c(String paramString)
  {
    return a(paramString);
  }

  public String getCompositeUuid()
  {
    return q().getEditUuid() + "element";
  }

  private String[] d(String paramString)
  {
    String[] arrayOfString1 = q().getPreferences().getStringArray(paramString);
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = a(arrayOfString1[i]);
    return arrayOfString2;
  }

  public void a(PageElementModel paramPageElementModel, String paramString)
  {
    String[] arrayOfString = q().getPreferences().getStringArray(paramString + ".prop");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if (paramPageElementModel.getProperty(arrayOfString[i]) != null)
          continue;
        paramPageElementModel.setPropertyValue(arrayOfString[i], q().getPreferences().getString(arrayOfString[i] + ".defaultvalue", ""));
      }
  }

  protected boolean a(Menu paramMenu, Item[] paramArrayOfItem)
  {
    if (paramArrayOfItem == null)
    {
      a(paramMenu, "paste");
    }
    else if (paramArrayOfItem.length == 1)
    {
      if ((!b()) && ((paramArrayOfItem[0].getData() instanceof PageElementModel)))
      {
        localMenuItem = new MenuItem(paramMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("newField.edit"));
        localMenuItem.addListener(13, new Q(this, paramArrayOfItem));
        new MenuItem(paramMenu, 2);
        a(paramMenu, "moveUp");
        a(paramMenu, "moveDown");
        new MenuItem(paramMenu, 2);
        a(paramMenu, "delete");
        a(paramMenu, "cut");
        a(paramMenu, "copy");
        a(paramMenu, "paste");
        new MenuItem(paramMenu, 2);
      }
    }
    else
    {
      a(paramMenu, "delete");
      a(paramMenu, "cut");
      a(paramMenu, "copy");
      new MenuItem(paramMenu, 2);
    }
    MenuItem localMenuItem = new MenuItem(paramMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("add.popup"));
    localMenuItem.addListener(13, new R(this));
    return super.a(paramMenu, paramArrayOfItem);
  }

  private void r()
  {
    V localV = new V(this);
    if ((localV.open() == 0) && (a(localV.c())))
      try
      {
        PageElementModel localPageElementModel = new PageElementModel(localV.b(), this.q[localV.c()], localV.a());
        q().addChildElement(localPageElementModel);
        update();
        q().setModified(true);
      }
      catch (p localp)
      {
        a().getRulesManager().j().a(localV.a() + localp.getMessage());
      }
  }

  protected c a(IElement paramIElement, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
      return new S(this, paramIElement);
    if (paramInt == 0)
      return new T(this, paramIElement);
    if (paramInt == 2)
      a((PageElementModel)paramIElement, paramInt);
    return super.a(paramIElement, paramInt, paramBoolean);
  }

  private void a(PageElementModel paramPageElementModel, int paramInt)
  {
    com.flagleader.builder.dialogs.d.a locala = new com.flagleader.builder.dialogs.d.a(paramPageElementModel);
    if ((locala.open() == 0) && (!b()))
    {
      String str = "{";
      AdvancedProperty[] arrayOfAdvancedProperty = paramPageElementModel.getAdvanceProperties();
      for (int i = 0; i < arrayOfAdvancedProperty.length; i++)
        str = str + arrayOfAdvancedProperty[i].toString() + ",";
      str = str + "}";
      if (locala.o())
      {
        q().setModified(true);
        if (f() > 0)
          c(i()[0]);
      }
    }
  }

  public boolean canPaste()
  {
    Object localObject1 = new Clipboard(Display.getCurrent()).getContents(d.a());
    if (localObject1 == null)
      return false;
    if ((localObject1 instanceof PageElementModel))
      return true;
    if ((localObject1 instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)localObject1).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof PageElementModel))
          return true;
      }
    }
    return false;
  }

  public boolean canRedo()
  {
    return q().canRedo();
  }

  public boolean canUndo()
  {
    return q().canUndo();
  }

  public void copy()
  {
    ElementContainer localElementContainer = new ElementContainer();
    IElement[] arrayOfIElement = g();
    for (int i = 0; i < arrayOfIElement.length; i++)
    {
      if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof PageElementModel)) || (!((PageElementModel)arrayOfIElement[i]).getParent().equals(q())))
        continue;
      localElementContainer.addChildElement(((PageElementModel)arrayOfIElement[i]).deepClone());
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
  }

  public void cut()
  {
    ElementContainer localElementContainer = new ElementContainer();
    IElement[] arrayOfIElement = g();
    if ((arrayOfIElement == null) || (arrayOfIElement.length == 0))
      return;
    for (int i = 0; i < arrayOfIElement.length; i++)
    {
      if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof PageElementModel)) || (!((PageElementModel)arrayOfIElement[i]).getParent().equals(q())))
        continue;
      localElementContainer.addChildElement(((PageElementModel)arrayOfIElement[i]).deepClone());
      ((PageElementModel)arrayOfIElement[i]).dispose();
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
    q().setModified(true);
    update();
  }

  public void delete()
  {
    IElement[] arrayOfIElement = g();
    if ((arrayOfIElement == null) || (arrayOfIElement.length == 0))
      return;
    for (int i = 0; i < arrayOfIElement.length; i++)
    {
      if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof PageElementModel)))
        continue;
      ((PageElementModel)arrayOfIElement[i]).dispose();
    }
    q().setModified(true);
    update();
  }

  public boolean paste()
  {
    int i = -1;
    if (this.e.getSelectionCount() == 1)
      i = q().getElementPos((IElement)this.e.getSelection()[0].getData());
    Object localObject = new Clipboard(Display.getCurrent()).getContents(d.a());
    if ((localObject != null) && (((localObject instanceof PageElementModel)) || ((localObject instanceof ElementContainer))))
    {
      if (q().pasteElement(((IElement)localObject).deepClone(), i))
        q().setModified(true);
      update();
      return true;
    }
    return false;
  }

  public boolean redo()
  {
    boolean bool = super.redo();
    if (bool)
    {
      q().setModified(true);
      update();
    }
    return bool;
  }

  public void selectAll()
  {
    this.e.setSelection(this.e.getItems());
    setChanged();
    notifyObservers();
  }

  public boolean undo()
  {
    boolean bool = super.undo();
    if (bool)
    {
      q().setModified(true);
      update();
    }
    return bool;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.P
 * JD-Core Version:    0.6.0
 */