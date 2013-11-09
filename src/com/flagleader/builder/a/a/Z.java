package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.an;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.d;
import com.flagleader.engine.Property;
import com.flagleader.manager.r;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.db.MapValue;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.h;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class Z extends an
  implements IElementViewer
{
  private static final int q = 1;
  private static final int r = 2;
  private int s = 1;

  public Z(SheetMap paramSheetMap, Composite paramComposite, bu parambu)
  {
    super(paramSheetMap, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new Z((SheetMap)this.c, paramComposite, this.a);
  }

  protected void h()
  {
    a(new ab(this));
    a(new aa(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "add");
    a(paramToolBar, "moveUp");
    a(paramToolBar, "moveDown");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "undo");
    a(paramToolBar, "redo");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "cut");
    a(paramToolBar, "copy");
    a(paramToolBar, "paste");
    a(paramToolBar, "delete");
    a(paramToolBar, "selectall");
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "import");
    a(paramToolBar, "exportxls");
    super.a(paramToolBar);
  }

  protected SheetMap q()
  {
    return (SheetMap)this.c;
  }

  protected void k()
  {
    for (int i = 0; i < q().getFields().size(); i++)
    {
      if (!(q().getFields().get(i) instanceof MapValue))
        continue;
      MapValue localMapValue = (MapValue)q().getFields().get(i);
      TableItem localTableItem = new TableItem(this.e, 0);
      localTableItem.setText(new String[] { i + 1, localMapValue.getKey(), localMapValue.getValue() });
      localTableItem.setData(localMapValue);
    }
  }

  protected void a(TableItem paramTableItem)
  {
    MapValue localMapValue = (MapValue)paramTableItem.getData();
    paramTableItem.setText(1, localMapValue.getKey());
    paramTableItem.setText(2, localMapValue.getValue());
  }

  protected void j()
  {
    super.j();
    this.e.addMouseListener(new ac(this, null));
  }

  public void i()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.SheetMapDataView");
    String[] arrayOfString2 = ResourceTools.getStringArray("lengths.SheetMapDataView");
    String[] arrayOfString3 = new String[arrayOfString1.length + 1];
    String[] arrayOfString4 = new String[arrayOfString1.length + 1];
    int[] arrayOfInt = new int[arrayOfString1.length + 1];
    arrayOfString3[0] = "";
    arrayOfString4[0] = "int";
    arrayOfInt[0] = 30;
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString3[(i + 1)] = ResourceTools.getMessage(arrayOfString1[i] + ".SheetMapDataView");
      arrayOfInt[(i + 1)] = Integer.parseInt(arrayOfString2[i]);
      arrayOfString4[(i + 1)] = "string";
    }
    for (i = 0; i < arrayOfString3.length; i++)
    {
      TableColumn localTableColumn = new TableColumn(this.e, 8388608);
      localTableColumn.setText(arrayOfString3[i]);
      localTableColumn.setWidth(arrayOfInt[i]);
    }
    this.e.setHeaderVisible(true);
  }

  public String getCompositeUuid()
  {
    return q().getEditUuid() + "data";
  }

  public boolean isCanFind()
  {
    return true;
  }

  public void a(File paramFile)
  {
    Object localObject = null;
    if (paramFile.getName().endsWith(".xls"))
      localObject = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(paramFile)));
    else
      localObject = new XSSFWorkbook(paramFile.getPath());
    Sheet localSheet = ((Workbook)localObject).getSheetAt(0);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    FormulaEvaluator localFormulaEvaluator = ((Workbook)localObject).getCreationHelper().createFormulaEvaluator();
    for (int i = 1; i < 65536; i++)
    {
      Row localRow = localSheet.getRow(i);
      if ((localRow == null) || (localRow.getCell(0) == null))
        break;
      String str = a(localRow.getCell(0));
      if (str.length() <= 0)
        break;
      localArrayList1.add(str);
      localArrayList3.add(a(localRow.getCell(1)));
    }
    q().replaceVariables(localArrayList1, localArrayList2, localArrayList3, localArrayList4);
  }

  protected String a(Cell paramCell)
  {
    if (paramCell != null)
      switch (paramCell.getCellType())
      {
      case 4:
        return String.valueOf(paramCell.getBooleanCellValue());
      case 0:
        if (DateUtil.isCellDateFormatted(paramCell))
          return Property.getInstance().formatDate(paramCell.getDateCellValue());
        return StringUtil.stringValue(paramCell.getNumericCellValue());
      case 1:
        return paramCell.getStringCellValue();
      case 3:
        break;
      case 2:
      case 5:
      }
    return "";
  }

  public boolean canPaste()
  {
    if (b())
      return false;
    Object localObject1 = new Clipboard(Display.getCurrent()).getContents(d.a());
    if (localObject1 == null)
      return false;
    if ((localObject1 instanceof IBusinessObjectEditen))
      return true;
    if ((localObject1 instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)localObject1).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof IBusinessObjectEditen))
          return true;
      }
    }
    return false;
  }

  protected int r()
  {
    return this.e.getSelectionCount();
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
    if (r() <= 0)
      return;
    IElement[] arrayOfIElement = m();
    if (arrayOfIElement.length == 1)
    {
      new Clipboard(Display.getCurrent()).setContents(new Object[] { arrayOfIElement[0] }, new Transfer[] { d.a() });
    }
    else
    {
      ElementContainer localElementContainer = new ElementContainer();
      for (int i = 0; i < arrayOfIElement.length; i++)
      {
        if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof IElement)) || (!arrayOfIElement[i].getParent().equals(q())))
          continue;
        localElementContainer.addChildElement(arrayOfIElement[i].deepClone());
      }
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
    }
  }

  public void cut()
  {
    if (b())
      return;
    if (r() <= 0)
      return;
    ElementContainer localElementContainer = new ElementContainer();
    IElement[] arrayOfIElement = m();
    if (arrayOfIElement.length > 0)
    {
      q().initUndoable();
      for (int i = 0; i < arrayOfIElement.length; i++)
      {
        if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof MapValue)) || (!((MapValue)arrayOfIElement[i]).getParent().equals(q())))
          continue;
        localElementContainer.addChildElement(((MapValue)arrayOfIElement[i]).deepClone());
        q().removeSheetValue((MapValue)arrayOfIElement[i]);
      }
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { d.a() });
      q().setModified(true);
      q().takeSnapshot();
      q().updateViewer();
    }
  }

  public void delete()
  {
    if (b())
      return;
    if (r() <= 0)
      return;
    IElement[] arrayOfIElement = m();
    if (arrayOfIElement.length > 0)
    {
      q().initUndoable();
      for (int i = 0; i < arrayOfIElement.length; i++)
      {
        if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof MapValue)))
          continue;
        q().removeSheetValue((MapValue)arrayOfIElement[i]);
      }
      q().setModified(true);
      q().takeSnapshot();
      q().updateViewer();
    }
  }

  public boolean paste()
  {
    if (b())
      return false;
    int i = -1;
    if (r() == 1)
      i = q().getElementPos(m()[0]);
    Object localObject = new Clipboard(Display.getCurrent()).getContents(d.a());
    if ((localObject != null) && (((localObject instanceof IBusinessObjectEditen)) || ((localObject instanceof ElementContainer))))
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
    boolean bool = q().redo();
    update();
    return bool;
  }

  public boolean undo()
  {
    boolean bool = q().undo();
    update();
    return bool;
  }

  protected void s()
  {
    ah localah = t();
    if ((localah.open() == 0) && (localah.a().length() > 0) && (q().canCreateEditen()))
      try
      {
        q().initUndoable();
        q().addSheetValue(localah.a(), localah.b());
        q().setModified(true);
        update();
      }
      catch (p localp)
      {
        a().getRulesManager().j().a(localah.a() + localp.getMessage());
      }
  }

  protected int n()
  {
    return 1;
  }

  protected ah t()
  {
    return new ah(this);
  }

  public boolean canDelete()
  {
    return true;
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return true;
  }

  public boolean isCanSelectAll()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.Z
 * JD-Core Version:    0.6.0
 */