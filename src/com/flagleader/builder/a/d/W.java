package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.a.c.c;
import com.flagleader.builder.widget.d;
import com.flagleader.export.IExportField;
import com.flagleader.export.PagesMessages;
import com.flagleader.export.Type;
import com.flagleader.manager.d.b;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.collections.k;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class W extends o
  implements IElementViewer
{
  private static final String r = "columns.JspFieldEditor";
  String[] q = ResourceTools.getStringArray("columns.JspFieldEditor");

  public W(IPage paramIPage, Composite paramComposite, bu parambu)
  {
    super(paramIPage, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new W((ExportModel)this.c, paramComposite, this.a);
  }

  protected boolean a(String paramString)
  {
    return q().getPreferences().getString(paramString + ".NAME") != null;
  }

  protected String c(String paramString)
  {
    return q().getPreferences().getString(paramString + ".NAME", "");
  }

  protected void h()
  {
    a(new ah(this));
    a(new ai(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "add");
    a(paramToolBar, "addSubFunc");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected IPage q()
  {
    return (IPage)this.c;
  }

  protected String[] k()
  {
    if (q().getPreferences().getStringArray(q().getImportFile() + ".PageField") != null)
      this.q = q().getPreferences().getStringArray(q().getImportFile() + ".PageField");
    String[] arrayOfString = new String[this.q.length];
    for (int i = 0; i < this.q.length; i++)
      arrayOfString[i] = String.valueOf(q().getPreferences().getInt(this.q[i] + ".width", 100));
    return arrayOfString;
  }

  protected String[] j()
  {
    if (q().getPreferences().getStringArray(q().getImportFile() + ".PageField") != null)
      this.q = q().getPreferences().getStringArray(q().getImportFile() + ".PageField");
    String[] arrayOfString = new String[this.q.length];
    for (int i = 0; i < this.q.length; i++)
      arrayOfString[i] = q().getPreferences().getString(this.q[i] + ".column", this.q[i]);
    return arrayOfString;
  }

  protected boolean m()
  {
    return !b();
  }

  protected void a(Item paramItem, IElement paramIElement)
  {
    if ((paramIElement instanceof PageFieldModel))
    {
      a(paramItem, false, a((PageFieldModel)paramIElement));
      Iterator localIterator = ((PageFieldModel)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof PageFieldModel))
          continue;
        PageFieldModel localPageFieldModel = (PageFieldModel)localObject;
        Item localItem = d(paramItem);
        localItem.setData(localPageFieldModel);
        a(localItem, localPageFieldModel);
      }
      b(paramItem);
    }
  }

  protected void p()
  {
    List localList = q().getPageFields();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof PageFieldModel))
        continue;
      PageFieldModel localPageFieldModel = (PageFieldModel)localList.get(i);
      Item localItem = d(null);
      localItem.setData(localPageFieldModel);
      a(localItem, localPageFieldModel);
    }
    for (i = 10; i < this.e.getColumnCount(); i++)
      this.e.getColumns()[i].pack();
  }

  protected String[] a(PageFieldModel paramPageFieldModel)
  {
    String[] arrayOfString = new String[this.q.length];
    String str = "{";
    AdvancedProperty[] arrayOfAdvancedProperty = paramPageFieldModel.getAdvanceProperties();
    for (int i = 0; i < arrayOfAdvancedProperty.length; i++)
      str = str + arrayOfAdvancedProperty[i].toString() + ",";
    str = str + "}";
    for (i = 0; i < this.q.length; i++)
      if (this.q[i].equalsIgnoreCase("PageInOut"))
      {
        arrayOfString[i] = d(paramPageFieldModel.getStatType());
      }
      else if (this.q[i].equalsIgnoreCase("InputType"))
      {
        arrayOfString[i] = d(paramPageFieldModel.getInputValueType());
      }
      else if (this.q[i].equalsIgnoreCase("PageInput"))
      {
        arrayOfString[i] = d(paramPageFieldModel.getInputType());
      }
      else if (this.q[i].equalsIgnoreCase("PageOut"))
      {
        arrayOfString[i] = d(paramPageFieldModel.getResultType());
      }
      else if (this.q[i].equalsIgnoreCase("varDisplay"))
      {
        arrayOfString[i] = paramPageFieldModel.getDisplayName();
      }
      else if (this.q[i].equalsIgnoreCase("varName"))
      {
        arrayOfString[i] = paramPageFieldModel.getVariableName();
      }
      else if (this.q[i].equalsIgnoreCase("varType"))
      {
        arrayOfString[i] = paramPageFieldModel.getValueType();
      }
      else if (this.q[i].equalsIgnoreCase("varLength"))
      {
        arrayOfString[i] = paramPageFieldModel.getLen();
      }
      else if (this.q[i].equalsIgnoreCase("PageNull"))
      {
        arrayOfString[i] = d(paramPageFieldModel.getNullType());
      }
      else if (this.q[i].equalsIgnoreCase("showValue"))
      {
        arrayOfString[i] = d(paramPageFieldModel.getShowValue());
      }
      else if (this.q[i].equalsIgnoreCase("valueFrom"))
      {
        arrayOfString[i] = d(paramPageFieldModel.getValueFrom());
      }
      else
      {
        if (!this.q[i].equalsIgnoreCase("DataChange"))
          continue;
        arrayOfString[i] = str;
      }
    return arrayOfString;
  }

  private String d(String paramString)
  {
    return c(paramString);
  }

  public String getCompositeUuid()
  {
    return q().getEditUuid() + "page";
  }

  private String[] e(String paramString)
  {
    String[] arrayOfString1 = q().getPreferences().getStringArray(paramString);
    if (arrayOfString1 == null)
      return null;
    String[] arrayOfString2 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
      arrayOfString2[i] = c(arrayOfString1[i]);
    return arrayOfString2;
  }

  public static void a(PageFieldModel paramPageFieldModel, String paramString)
  {
    String[] arrayOfString = paramPageFieldModel.getPage().getPreferences().getStringArray(paramString + ".prop");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if (!paramPageFieldModel.isEmptyProp(arrayOfString[i]))
          continue;
        paramPageFieldModel.setPropertyValue(arrayOfString[i], paramPageFieldModel.getPage().getPreferences().getString(arrayOfString[i] + ".defaultvalue", ""));
      }
  }

  public void b(PageFieldModel paramPageFieldModel)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramPageFieldModel.getPageTypes();
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      String[] arrayOfString3 = q().getPreferences().getStringArray(arrayOfString1[i] + ".prop");
      if ((arrayOfString3 == null) || (arrayOfString3.length <= 0))
        continue;
      for (int m = 0; m < arrayOfString3.length; m++)
      {
        if (localHashMap.get(arrayOfString3[m]) != null)
          continue;
        localHashMap.put(arrayOfString3[m], arrayOfString3[m]);
        localArrayList.add(arrayOfString3[m]);
      }
    }
    String[] arrayOfString2;
    if ((paramPageFieldModel.getParent() instanceof IPage))
    {
      if (q().getPreferences().getStringArray(((IPage)paramPageFieldModel.getParent()).getImportFile() + ".fprops") != null)
      {
        arrayOfString2 = q().getPreferences().getStringArray(((IPage)paramPageFieldModel.getParent()).getImportFile() + ".fprops");
        for (int k = 0; k < arrayOfString2.length; k++)
        {
          if ((localHashMap.get(arrayOfString2[k]) != null) || (arrayOfString2[k].endsWith("_")))
            continue;
          localHashMap.put(arrayOfString2[k], arrayOfString2[k]);
          localArrayList.add(arrayOfString2[k]);
        }
      }
    }
    else if ((paramPageFieldModel.getParent() instanceof PageFieldModel))
    {
      arrayOfString2 = (String[])null;
      PageFieldModel localPageFieldModel = (PageFieldModel)paramPageFieldModel.getParent();
      if (q().getPreferences().getStringArray(localPageFieldModel.getInputType() + ".fprops") != null)
        arrayOfString2 = q().getPreferences().getStringArray(localPageFieldModel.getInputType() + ".fprops");
      else if (q().getPreferences().getStringArray(localPageFieldModel.getResultType() + ".fprops") != null)
        arrayOfString2 = q().getPreferences().getStringArray(localPageFieldModel.getResultType() + ".fprops");
      a(arrayOfString2, localHashMap, localArrayList);
    }
    a(q().getPreferences().getStringArray("field.fprops"), localHashMap, localArrayList);
    if (localArrayList.size() > 0)
      for (int j = 0; j < localArrayList.size(); j++)
      {
        if ((paramPageFieldModel.getProperty(localArrayList.get(j).toString()) != null) || (q().getPreferences().getString(localArrayList.get(j).toString() + ".defaultvalue", "").length() <= 0))
          continue;
        paramPageFieldModel.setPropertyValue(localArrayList.get(j).toString(), q().getPreferences().getString(localArrayList.get(j).toString() + ".defaultvalue", ""));
      }
  }

  private void a(String[] paramArrayOfString, HashMap paramHashMap, ArrayList paramArrayList)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      for (int i = 0; i < paramArrayOfString.length; i++)
      {
        if ((paramHashMap.get(paramArrayOfString[i]) != null) || (paramArrayOfString[i].endsWith("_")))
          continue;
        paramHashMap.put(paramArrayOfString[i], paramArrayOfString[i]);
        paramArrayList.add(paramArrayOfString[i]);
      }
  }

  protected boolean a(Menu paramMenu, Item[] paramArrayOfItem)
  {
    Object localObject;
    if (paramArrayOfItem == null)
    {
      a(paramMenu, "paste");
    }
    else if (paramArrayOfItem.length == 1)
    {
      if ((!b()) && ((paramArrayOfItem[0].getData() instanceof PageFieldModel)))
      {
        localObject = (PageFieldModel)paramArrayOfItem[0].getData();
        MenuItem localMenuItem = new MenuItem(paramMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("newField.edit"));
        localMenuItem.addListener(13, new X(this, (PageFieldModel)localObject, paramArrayOfItem));
        if ((paramArrayOfItem[0].getData() instanceof PageFieldModel))
          if ((((PageFieldModel)paramArrayOfItem[0].getData()).getJavaType().isListList()) || (((PageFieldModel)paramArrayOfItem[0].getData()).getJavaType().isSheet()))
          {
            localMenuItem = new MenuItem(paramMenu, 8);
            localMenuItem.setText(ResourceTools.getMessage("loadTableList.edit", "Load Table List"));
            localMenuItem.addListener(13, new Z(this, paramArrayOfItem));
          }
          else if (((PageFieldModel)paramArrayOfItem[0].getData()).getInputType().equals("combobox"))
          {
            localMenuItem = new MenuItem(paramMenu, 8);
            localMenuItem.setText(ResourceTools.getMessage("initcombobox.edit", "init combobox "));
            localMenuItem.addListener(13, new aa(this, paramArrayOfItem));
          }
          else if (((PageFieldModel)paramArrayOfItem[0].getData()).getInputType().equals("combogrid"))
          {
            localMenuItem = new MenuItem(paramMenu, 8);
            localMenuItem.setText(ResourceTools.getMessage("initcombobox.edit", "init combobox "));
            localMenuItem.addListener(13, new ab(this, paramArrayOfItem));
          }
          else if (((PageFieldModel)paramArrayOfItem[0].getData()).getInputType().equals("combotree"))
          {
            localMenuItem = new MenuItem(paramMenu, 8);
            localMenuItem.setText(ResourceTools.getMessage("initcombobox.edit", "init combobox "));
            localMenuItem.addListener(13, new ac(this, paramArrayOfItem));
          }
          else if (((PageFieldModel)paramArrayOfItem[0].getData()).getInputType().equals("textauto"))
          {
            localMenuItem = new MenuItem(paramMenu, 8);
            localMenuItem.setText(ResourceTools.getMessage("initcombobox.edit", "init combobox "));
            localMenuItem.addListener(13, new ad(this, paramArrayOfItem));
          }
          else if (((PageFieldModel)paramArrayOfItem[0].getData()).getInputType().equals("textblur"))
          {
            localMenuItem = new MenuItem(paramMenu, 8);
            localMenuItem.setText(ResourceTools.getMessage("initcombobox.edit", "init combobox "));
            localMenuItem.addListener(13, new ae(this, paramArrayOfItem));
          }
        localMenuItem = new MenuItem(paramMenu, 2);
        a(paramMenu, "moveUp");
        a(paramMenu, "moveDown");
        localMenuItem = new MenuItem(paramMenu, 2);
        a(paramMenu, "delete");
        a(paramMenu, "cut");
        a(paramMenu, "copy");
        a(paramMenu, "paste");
        localMenuItem = new MenuItem(paramMenu, 2);
      }
    }
    else if ((paramArrayOfItem.length > 1) && (!b()) && ((paramArrayOfItem[0].getData() instanceof PageFieldModel)))
    {
      a(paramMenu, "delete");
      a(paramMenu, "cut");
      a(paramMenu, "copy");
      new MenuItem(paramMenu, 2);
    }
    if (!q().isLocked())
    {
      localObject = new MenuItem(paramMenu, 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("importvariable.edit"));
      ((MenuItem)localObject).addListener(13, new af(this));
      localObject = new MenuItem(paramMenu, 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("loadFieldLength.edit", "Load Table List"));
      ((MenuItem)localObject).addListener(13, new ag(this));
    }
    return super.a(paramMenu, paramArrayOfItem);
  }

  private boolean a(PageFieldModel paramPageFieldModel, String paramString1, String paramString2)
  {
    if (paramString2.equalsIgnoreCase("PageInOut"))
    {
      if ((a(paramString1)) && (!paramPageFieldModel.getStatType().equalsIgnoreCase(paramString1)))
      {
        paramPageFieldModel.setStatType(paramString1);
        if ((paramString1.equals("error")) || (paramString1.equals("success")))
        {
          paramPageFieldModel.setResultType("notdisplay");
          paramPageFieldModel.setInputType("notdisplay");
        }
        a(paramPageFieldModel, paramPageFieldModel.getInputType());
        a(paramPageFieldModel, paramPageFieldModel.getResultType());
        q().setModified(true);
        return true;
      }
    }
    else if (paramString2.equalsIgnoreCase("InputType"))
    {
      if ((a(paramString1)) && (!paramPageFieldModel.getInputValueType().equalsIgnoreCase(paramString1)))
      {
        paramPageFieldModel.setInputValueType(paramString1);
        a(paramPageFieldModel, paramString1);
        q().setModified(true);
        return true;
      }
    }
    else
    {
      String str1;
      if (paramString2.equalsIgnoreCase("PageInput"))
      {
        if ((a(paramString1)) && (!paramPageFieldModel.getInputType().equalsIgnoreCase(paramString1)))
        {
          str1 = paramString1;
          paramPageFieldModel.setInputType(str1);
          a(paramPageFieldModel, str1);
          q().setModified(true);
          return true;
        }
      }
      else if (paramString2.equalsIgnoreCase("PageOut"))
      {
        if ((a(paramString1)) && (!paramPageFieldModel.getResultType().equalsIgnoreCase(paramString1)))
        {
          str1 = paramString1;
          paramPageFieldModel.setResultType(str1);
          a(paramPageFieldModel, str1);
          q().setModified(true);
          return true;
        }
      }
      else if (paramString2.equalsIgnoreCase("PageNull"))
      {
        if ((a(paramString1)) && (!paramPageFieldModel.getNullType().equalsIgnoreCase(paramString1)))
        {
          str1 = paramString1;
          paramPageFieldModel.setNullType(str1);
          a(paramPageFieldModel, str1);
          q().setModified(true);
          return true;
        }
      }
      else if (paramString2.equalsIgnoreCase("showValue"))
      {
        if ((a(paramString1)) && (!paramPageFieldModel.getShowValue().equalsIgnoreCase(paramString1)))
        {
          str1 = paramString1;
          paramPageFieldModel.setShowValue(str1);
          a(paramPageFieldModel, str1);
          q().setModified(true);
          return true;
        }
      }
      else if (paramString2.equalsIgnoreCase("valueFrom"))
      {
        if ((a(paramString1)) && (!paramPageFieldModel.getValueFrom().equalsIgnoreCase(paramString1)))
        {
          str1 = paramString1;
          paramPageFieldModel.setValueFrom(str1);
          a(paramPageFieldModel, str1);
          q().setModified(true);
          return true;
        }
      }
      else if (paramString2.equalsIgnoreCase("varDisplay"))
      {
        if (!paramPageFieldModel.getDisplayName().equals(paramString1))
        {
          paramPageFieldModel.setDisplayName(paramString1);
          q().setModified(true);
          return true;
        }
      }
      else if (paramString2.equalsIgnoreCase("varLength"))
      {
        if (!paramPageFieldModel.getLen().equals(paramString1))
        {
          paramPageFieldModel.setLen(paramString1);
          q().setModified(true);
          return true;
        }
      }
      else if (paramString2.equalsIgnoreCase("varName"))
      {
        if ((paramPageFieldModel.getParent() != null) && ((paramPageFieldModel.getParent() instanceof PageFieldModel)) && (paramString1.indexOf("_") < 0))
          paramString1 = ((PageFieldModel)paramPageFieldModel.getParent()).getVariableName() + "_" + paramString1;
        if (!paramPageFieldModel.getVariableName().equals(paramString1))
        {
          if (paramPageFieldModel.getChildFields().length > 0)
            for (int i = 0; i < paramPageFieldModel.getChildFields().length; i++)
            {
              String str2 = paramPageFieldModel.getChildFields()[i].getVariableName();
              paramPageFieldModel.getChildFields()[i].setVariableName(StringUtil.replace(paramPageFieldModel.getVariableName(), paramString1, str2));
            }
          paramPageFieldModel.setVariableName(paramString1);
          q().setModified(true);
          if (a().getConfigManager().E())
            a().getRulesManager().c().a(q());
          return true;
        }
      }
    }
    return false;
  }

  private String[] b(PageFieldModel paramPageFieldModel, String paramString)
  {
    if ((paramPageFieldModel.getParent() instanceof PageFieldModel))
    {
      PageFieldModel localPageFieldModel = (PageFieldModel)paramPageFieldModel.getParent();
      if (e(localPageFieldModel.getInputType() + "." + paramString) != null)
        return e(localPageFieldModel.getInputType() + "." + paramString);
      if (e(localPageFieldModel.getResultType() + "." + paramString) != null)
        return e(localPageFieldModel.getResultType() + "." + paramString);
    }
    if (e(q().getImportFile() + "." + paramString) != null)
      return e(q().getImportFile() + "." + paramString);
    return e(paramString + ".choise");
  }

  private String[] c(PageFieldModel paramPageFieldModel, String paramString)
  {
    if ((paramPageFieldModel.getParent() instanceof PageFieldModel))
    {
      PageFieldModel localPageFieldModel = (PageFieldModel)paramPageFieldModel.getParent();
      if (q().getPreferences().getStringArray(localPageFieldModel.getInputType() + "." + paramString) != null)
        return q().getPreferences().getStringArray(localPageFieldModel.getInputType() + "." + paramString);
      if (q().getPreferences().getStringArray(localPageFieldModel.getResultType() + "." + paramString) != null)
        return q().getPreferences().getStringArray(localPageFieldModel.getResultType() + "." + paramString);
    }
    if (q().getPreferences().getStringArray(q().getImportFile() + "." + paramString) != null)
      return q().getPreferences().getStringArray(q().getImportFile() + "." + paramString);
    return q().getPreferences().getStringArray(paramString + ".choise");
  }

  protected c a(IElement paramIElement, int paramInt, boolean paramBoolean)
  {
    if (!(paramIElement instanceof PageFieldModel))
      return null;
    PageFieldModel localPageFieldModel = (PageFieldModel)paramIElement;
    if (this.q[paramInt].equalsIgnoreCase("PageInOut"))
      return new aj(this, "PageInOut", localPageFieldModel, paramBoolean);
    if (this.q[paramInt].equalsIgnoreCase("InputType"))
      return new aj(this, "InputType", localPageFieldModel, paramBoolean);
    if (this.q[paramInt].equalsIgnoreCase("PageInput"))
      return new aj(this, "PageInput", localPageFieldModel, paramBoolean);
    if (this.q[paramInt].equalsIgnoreCase("PageOut"))
      return new aj(this, "PageOut", localPageFieldModel, paramBoolean);
    if (this.q[paramInt].equalsIgnoreCase("varDisplay"))
      return new ak(this, "varDisplay", localPageFieldModel);
    if (this.q[paramInt].equalsIgnoreCase("varName"))
      return new ak(this, "varName", localPageFieldModel);
    if (this.q[paramInt].equalsIgnoreCase("varType"))
      return new Y(this, localPageFieldModel);
    if (this.q[paramInt].equalsIgnoreCase("varLength"))
      return new ak(this, "varLength", localPageFieldModel);
    if (this.q[paramInt].equalsIgnoreCase("PageNull"))
      return new aj(this, "PageNull", localPageFieldModel, paramBoolean);
    if (this.q[paramInt].equalsIgnoreCase("showValue"))
      return new aj(this, "showValue", localPageFieldModel, paramBoolean);
    if (this.q[paramInt].equalsIgnoreCase("valueFrom"))
      return new aj(this, "valueFrom", localPageFieldModel, paramBoolean);
    if (this.q[paramInt].equalsIgnoreCase("DataChange"))
      a(localPageFieldModel, paramInt);
    return super.a(paramIElement, paramInt, paramBoolean);
  }

  private void a(PageFieldModel paramPageFieldModel, int paramInt)
  {
    com.flagleader.builder.dialogs.d.a locala = new com.flagleader.builder.dialogs.d.a(paramPageFieldModel);
    if ((locala.open() == 0) && (!b()))
    {
      String str = "{";
      AdvancedProperty[] arrayOfAdvancedProperty = paramPageFieldModel.getAdvanceProperties();
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
    if ((localObject1 == null) || (b()))
      return false;
    if ((localObject1 instanceof PageFieldModel))
      return true;
    if ((localObject1 instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)localObject1).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof PageFieldModel))
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
      if ((!(arrayOfIElement[i] instanceof PageFieldModel)) || (!((PageFieldModel)arrayOfIElement[i]).getParent().equals(q())))
        continue;
      localElementContainer.addChildElement(((PageFieldModel)arrayOfIElement[i]).deepClone());
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
  }

  public void cut()
  {
    if (b())
      return;
    ElementContainer localElementContainer = new ElementContainer();
    IElement[] arrayOfIElement = g();
    if ((arrayOfIElement == null) || (arrayOfIElement.length == 0))
      return;
    for (int i = 0; i < arrayOfIElement.length; i++)
    {
      if ((!(arrayOfIElement[i] instanceof PageFieldModel)) || (!((PageFieldModel)arrayOfIElement[i]).getParent().equals(q())))
        continue;
      localElementContainer.addChildElement(((PageFieldModel)arrayOfIElement[i]).deepClone());
      ((PageFieldModel)arrayOfIElement[i]).dispose();
    }
    new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
    q().setModified(true);
    update();
  }

  public void delete()
  {
    if (b())
      return;
    IElement[] arrayOfIElement = g();
    if ((arrayOfIElement == null) || (arrayOfIElement.length == 0))
      return;
    for (int i = 0; i < arrayOfIElement.length; i++)
    {
      if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof PageFieldModel)))
        continue;
      ((PageFieldModel)arrayOfIElement[i]).dispose();
    }
    q().setModified(true);
    update();
  }

  public boolean paste()
  {
    if (b())
      return false;
    int i = -1;
    if (this.e.getSelectionCount() == 1)
      i = q().getElementPos((IElement)this.e.getSelection()[0].getData());
    Object localObject = new Clipboard(Display.getCurrent()).getContents(d.a());
    if ((localObject != null) && (((localObject instanceof PageFieldModel)) || ((localObject instanceof ElementContainer))))
    {
      q().pasteElement(((IElement)localObject).deepClone(), i);
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
      a().getRulesManager().c().a(q());
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

  private void e(Item paramItem)
  {
    PageFieldModel localPageFieldModel1 = (PageFieldModel)paramItem.getData();
    PageFieldModel localPageFieldModel2 = new PageFieldModel();
    String[] arrayOfString = localPageFieldModel2.getPageTypeNames();
    for (int i = 0; i < arrayOfString.length; i++)
      if (q().getPreferences().getStringArray(localPageFieldModel1.getInputType() + "." + arrayOfString[i]) != null)
        localPageFieldModel2.setPageTypeValue(arrayOfString[i], q().getPreferences().getStringArray(localPageFieldModel1.getInputType() + "." + arrayOfString[i])[0]);
      else if (q().getPreferences().getStringArray(localPageFieldModel1.getResultType() + "." + arrayOfString[i]) != null)
        localPageFieldModel2.setPageTypeValue(arrayOfString[i], q().getPreferences().getStringArray(localPageFieldModel1.getResultType() + "." + arrayOfString[i])[0]);
      else
        localPageFieldModel2.setPageTypeValue(arrayOfString[i], localPageFieldModel1.getPageTypeValue(arrayOfString[i]));
    localPageFieldModel2.setVariableName(localPageFieldModel1.getVariableName() + "_" + localPageFieldModel1.getChildrenCount());
    localPageFieldModel2.setValueType("string");
    localPageFieldModel1.addChildElement(localPageFieldModel2);
    Item localItem = d(paramItem);
    localItem.setData(localPageFieldModel2);
    b(localPageFieldModel2);
    q().setModified(true);
    c(localItem);
    b(paramItem);
    if (a().getConfigManager().E())
      a().getRulesManager().c().a(q());
  }

  private void r()
  {
    q().addEmptyFieldModel();
    update();
  }

  private void s()
  {
    IPage localIPage = q();
    com.flagleader.builder.dialogs.d.r localr = new com.flagleader.builder.dialogs.d.r(null, new k(new k(new k(localIPage.getEnvionment().getAllMappingVariable(), localIPage.getEnvionment().getExcelBookModels()), localIPage.getEnvionment().getXmlNodes()), localIPage.getEnvionment().getSheetTables()));
    if (localr.open() == 0)
    {
      List localList = localr.a();
      int i = 0;
      for (int j = 0; j < localList.size(); j++)
      {
        Object localObject;
        PageFieldModel localPageFieldModel;
        if ((localList.get(j) instanceof MappingVariable))
        {
          localObject = (MappingVariable)localList.get(j);
          if (q().getPageField(((MappingVariable)localObject).getVariableName()) != null)
            continue;
          localPageFieldModel = q().addMappingVariable((MappingVariable)localObject);
          a(localPageFieldModel, localPageFieldModel.getInputType());
          a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
        else if ((localList.get(j) instanceof ExcelBookModel))
        {
          localObject = (ExcelBookModel)localList.get(j);
          if (localIPage.getPageField(((ExcelBookModel)localObject).getVarValue()) != null)
            continue;
          localPageFieldModel = new PageFieldModel();
          localIPage.addChildElement(localPageFieldModel);
          localPageFieldModel.setVariableName(((ExcelBookModel)localObject).getVarValue());
          localPageFieldModel.setValueType(((ExcelBookModel)localObject).getValueType());
          localPageFieldModel.setDisplayName(((ExcelBookModel)localObject).getDisplayName());
          localPageFieldModel.setInputType("fileinput");
          a(localPageFieldModel, localPageFieldModel.getInputType());
          a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
        else if ((localList.get(j) instanceof XmlNode))
        {
          localObject = (XmlNode)localList.get(j);
          if (localIPage.getPageField(((XmlNode)localObject).getVarValue()) != null)
            continue;
          localPageFieldModel = new PageFieldModel();
          localIPage.addChildElement(localPageFieldModel);
          localPageFieldModel.setVariableName(((XmlNode)localObject).getVarValue());
          localPageFieldModel.setValueType(((XmlNode)localObject).getValueType());
          localPageFieldModel.setDisplayName(((XmlNode)localObject).getDisplayName());
          localPageFieldModel.setInputType("bigtext");
          a(localPageFieldModel, localPageFieldModel.getInputType());
          a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
        else
        {
          if (!(localList.get(j) instanceof SheetTable))
            continue;
          localObject = (SheetTable)localList.get(j);
          if (localIPage.getPageField(((SheetTable)localObject).getVarValue()) != null)
            continue;
          localPageFieldModel = new PageFieldModel();
          localIPage.addChildElement(localPageFieldModel);
          localPageFieldModel.setVariableName(((SheetTable)localObject).getVarValue());
          localPageFieldModel.setValueType(((SheetTable)localObject).getValueType());
          localPageFieldModel.setDisplayName(((SheetTable)localObject).getDisplayName());
          localPageFieldModel.setInputType("notdisplay");
          localPageFieldModel.setResultType("table");
          a(localPageFieldModel, localPageFieldModel.getInputType());
          a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
      }
      if (i != 0)
      {
        q().setModified(true);
        update();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.W
 * JD-Core Version:    0.6.0
 */