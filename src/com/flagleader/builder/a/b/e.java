package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.ax;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.actions.aq;
import com.flagleader.engine.Property;
import com.flagleader.manager.a;
import com.flagleader.manager.d.b;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.lang.GlobalMethod;
import com.flagleader.repository.lang.TypeMethod;
import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.PackageFieldGet;
import com.flagleader.repository.rlm.action.PackageFieldSet;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.rom.SubTypeMethod;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class e extends ax
  implements IElementViewer
{
  public e(IBusinessObjectContainer paramIBusinessObjectContainer, Composite paramComposite, bu parambu)
  {
    super(paramIBusinessObjectContainer, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new e((IBusinessObjectContainer)this.c, paramComposite, this.a);
  }

  protected void h()
  {
    a(new v(this));
    a(new w(this));
    a(new u(this));
    a(new x(this));
    if ((K() instanceof ValueLibrary))
      a(new B(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "add");
    a(paramToolBar, "addSubFunc");
    a(paramToolBar, "addTypeMethod");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "findobj");
    if ((K() instanceof ValueLibrary))
      a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected String[] o()
  {
    return ResourceTools.getStringArray("lengths.BusinessObjectEditor");
  }

  protected void a(int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString = p();
    if (arrayOfString == null)
      K().sortBy(paramInt, "string", paramBoolean);
    else
      super.a(paramInt, arrayOfString[paramInt], paramBoolean);
  }

  protected boolean r()
  {
    return true;
  }

  protected String[] p()
  {
    return ResourceTools.getStringArray("types.BusinessObjectEditor");
  }

  protected String[] n()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.BusinessObjectEditor");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (ResourceTools.getMessage(arrayOfString[i] + ".BusinessObjectEditor") == null)
        continue;
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".BusinessObjectEditor");
    }
    return arrayOfString;
  }

  protected void a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.keyCode == 16777229) && (j() == 1))
    {
      H();
      paramKeyEvent.doit = false;
    }
    super.a(paramKeyEvent);
  }

  protected boolean q()
  {
    return !b();
  }

  protected void a(Menu paramMenu, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  protected boolean a(Menu paramMenu, IElement[] paramArrayOfIElement, int paramInt)
  {
    MenuItem localMenuItem;
    if ((paramArrayOfIElement == null) || (paramArrayOfIElement.length == 0) || ((paramArrayOfIElement.length == 1) && (!(paramArrayOfIElement[0] instanceof IBusinessObjectEditen))))
    {
      if (!b())
      {
        localMenuItem = new MenuItem(paramMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("add.popup", "add"));
        localMenuItem.addListener(13, new f(this));
        localMenuItem = new MenuItem(paramMenu, 2);
        a(paramMenu, "paste");
      }
    }
    else if ((paramArrayOfIElement.length == 1) && ((paramArrayOfIElement[0] instanceof IBusinessObjectEditen)))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramArrayOfIElement[0];
      if (!b())
      {
        a(paramMenu, localIBusinessObjectEditen);
        if (localIBusinessObjectEditen.canCreateSubFunction())
        {
          localMenuItem = new MenuItem(paramMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("addSubFunc.popup", "add sub function"));
          localMenuItem.addListener(13, new m(this, localIBusinessObjectEditen));
          localMenuItem = new MenuItem(paramMenu, 2);
        }
        if ((localIBusinessObjectEditen instanceof IFunctionObject))
        {
          localMenuItem = new MenuItem(paramMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("changeParams.popup", "change function parameters"));
          localMenuItem.addListener(13, new n(this, localIBusinessObjectEditen));
        }
        Iterator localIterator = J().a(localIBusinessObjectEditen.getJavaType());
        if (localIterator.hasNext())
        {
          localMenuItem = new MenuItem(paramMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("addTypeMethod.popup", "add type method"));
          localMenuItem.addListener(13, new o(this, localIBusinessObjectEditen));
          localMenuItem = new MenuItem(paramMenu, 2);
        }
        if (localIBusinessObjectEditen.getJavaType().s())
        {
          localMenuItem = new MenuItem(paramMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("addListElement.popup", "add list element"));
          localMenuItem.addListener(13, new p(this, localIBusinessObjectEditen));
          localMenuItem = new MenuItem(paramMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("addListSet.popup", "add list element"));
          localMenuItem.addListener(13, new q(this, localIBusinessObjectEditen));
          localMenuItem = new MenuItem(paramMenu, 2);
        }
        if (localIBusinessObjectEditen.getJavaType().n())
        {
          localMenuItem = new MenuItem(paramMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("addListElement.popup", "add list element"));
          localMenuItem.addListener(13, new r(this, localIBusinessObjectEditen));
          localMenuItem = new MenuItem(paramMenu, 2);
        }
        if (localIBusinessObjectEditen.canDelete())
        {
          a(paramMenu, "delete");
          a(paramMenu, "moveUp");
          a(paramMenu, "moveDown");
          localMenuItem = new MenuItem(paramMenu, 2);
          a(paramMenu, "cut");
          a(paramMenu, "copy");
          a(paramMenu, "paste");
          localMenuItem = new MenuItem(paramMenu, 2);
        }
        if ((localIBusinessObjectEditen instanceof BusinessObjectClass))
        {
          localMenuItem = new MenuItem(paramMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("updateClass.popup", "update Class"));
          localMenuItem.addListener(13, new s(this, localIBusinessObjectEditen));
        }
        if (((localIBusinessObjectEditen instanceof TempVariable)) || ((localIBusinessObjectEditen instanceof MappingVariable)) || ((localIBusinessObjectEditen instanceof SheetFieldModel)))
        {
          localMenuItem = new MenuItem(paramMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("movetosheet.popup", "move location"));
          localMenuItem.addListener(13, new t(this, localIBusinessObjectEditen));
        }
        if (((localIBusinessObjectEditen instanceof IVariableObject)) && (((IVariableObject)localIBusinessObjectEditen).canSetLoged()))
        {
          localMenuItem = new MenuItem(paramMenu, 8);
          IVariableObject localIVariableObject = (IVariableObject)localIBusinessObjectEditen;
          if (!localIVariableObject.isLoged())
            localMenuItem.setText(ResourceTools.getMessage("setloged.popup", "log"));
          else
            localMenuItem.setText(ResourceTools.getMessage("unloged.popup", "unlog"));
          localMenuItem.addListener(13, new g(this, localIVariableObject, localIBusinessObjectEditen));
        }
      }
      else
      {
        a(paramMenu, "copy");
      }
      a(paramMenu, "findobj");
      a(paramMenu, "search");
    }
    else if ((paramArrayOfIElement.length > 1) && (!b()))
    {
      a(paramMenu, "delete");
      localMenuItem = new MenuItem(paramMenu, 2);
      a(paramMenu, "cut");
      a(paramMenu, "copy");
      localMenuItem = new MenuItem(paramMenu, 2);
      localMenuItem = new MenuItem(paramMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("movetosheet.popup", "move location"));
      localMenuItem.addListener(13, new h(this));
      if (paramInt >= 0)
      {
        localMenuItem = new MenuItem(paramMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("batchrename.popup", "batch rename"));
        localMenuItem.addListener(13, new i(this, paramInt));
      }
      else
      {
        a(paramMenu, "copy");
      }
      localMenuItem = new MenuItem(paramMenu, 2);
    }
    return super.a(paramMenu, paramArrayOfIElement, paramInt);
  }

  protected void D()
  {
    if (b())
      return;
    Object localObject1;
    if ((K() instanceof FunctionLibrary))
    {
      localObject1 = "";
      Object localObject2;
      if (a().isPlugInApp())
      {
        localObject1 = a().loadNewClass("");
      }
      else
      {
        localObject2 = new com.flagleader.builder.dialogs.a.l(a(), K().getEnvionment(), "");
        if ((((com.flagleader.builder.dialogs.a.l)localObject2).open() == 0) && (((com.flagleader.builder.dialogs.a.l)localObject2).a().length() > 0))
          localObject1 = ((com.flagleader.builder.dialogs.a.l)localObject2).a();
      }
      if ((((String)localObject1).length() > 0) && (K().canCreateEditen()))
        try
        {
          K().initUndoable();
          localObject2 = K().createSubEditen((String)localObject1);
          ((IBusinessObjectEditen)localObject2).setVisible(true);
          K().takeSnapshot();
          if ((localObject2 != null) && (((IBusinessObjectEditen)localObject2).canCreateSubFunction()) && (!((IBusinessObjectEditen)localObject2).getJavaType().m()) && (((IBusinessObjectEditen)localObject2).getValueType().length() != 0) && (!((IBusinessObjectEditen)localObject2).getValueType().equals("Object")))
            a((IBusinessObjectEditen)localObject2);
          ((IBusinessObjectEditen)localObject2).update();
          K().setModified(true);
        }
        catch (com.flagleader.repository.d.p localp1)
        {
          Logger.getLogger("flagleader").log(Level.SEVERE, localObject1 + localp1.getMessage());
        }
    }
    else if ((K() instanceof ClassContainer))
    {
      localObject1 = "";
      Object localObject3;
      if (a().isPlugInApp())
      {
        localObject1 = a().loadNewClass("");
      }
      else
      {
        localObject3 = new com.flagleader.builder.dialogs.a.l(a(), K().getEnvionment(), "");
        if ((((com.flagleader.builder.dialogs.a.l)localObject3).open() == 0) && (((com.flagleader.builder.dialogs.a.l)localObject3).a().length() > 0))
          localObject1 = ((com.flagleader.builder.dialogs.a.l)localObject3).a();
      }
      if ((((String)localObject1).length() > 0) && (K().canCreateEditen()))
        try
        {
          K().initUndoable();
          localObject3 = K().createSubEditen((String)localObject1);
          K().takeSnapshot();
          if ((localObject3 != null) && (((IBusinessObjectEditen)localObject3).canCreateSubFunction()) && (!((IBusinessObjectEditen)localObject3).getJavaType().m()) && (((IBusinessObjectEditen)localObject3).getValueType().length() != 0))
            ((IBusinessObjectEditen)localObject3).getValueType().equals("Object");
          update();
          K().setModified(true);
        }
        catch (com.flagleader.repository.d.p localp2)
        {
          Logger.getLogger("flagleader").log(Level.SEVERE, localObject1 + localp2.getMessage());
        }
    }
    else
    {
      localObject1 = G();
      if ((((y)localObject1).open() == 0) && (((y)localObject1).a().length() > 0) && (K().canCreateEditen()))
        try
        {
          K().initUndoable();
          IBusinessObjectEditen localIBusinessObjectEditen = K().createSubEditen(((y)localObject1).a());
          if (((y)localObject1).c().length() > 0)
            localIBusinessObjectEditen.changeValueType(((y)localObject1).c());
          if (((y)localObject1).b().length() > 0)
            localIBusinessObjectEditen.setDisplayName(((y)localObject1).b());
          localIBusinessObjectEditen.setVisible(true);
          K().takeSnapshot();
          if ((localIBusinessObjectEditen != null) && (localIBusinessObjectEditen.canCreateSubFunction()) && (!localIBusinessObjectEditen.getJavaType().m()) && (localIBusinessObjectEditen.getValueType().length() != 0) && (!localIBusinessObjectEditen.getValueType().equals("Object")))
            a(localIBusinessObjectEditen);
          localIBusinessObjectEditen.update();
          K().setModified(true);
        }
        catch (com.flagleader.repository.d.p localp3)
        {
          Logger.getLogger("flagleader").log(Level.SEVERE, ((y)localObject1).a() + localp3.getMessage());
        }
    }
  }

  protected int a(int paramInt, IElement paramIElement)
  {
    if ((paramIElement == null) && (!b()))
    {
      if ((paramInt == 0) && (K().canCreateEditen()))
        return 1;
    }
    else if ((paramIElement instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramIElement;
      if ((paramInt == 0) && (localIBusinessObjectEditen.isValueEditable()))
        return 1;
      if (paramInt == 2)
        return 1;
      if ((paramInt == 1) && (localIBusinessObjectEditen.isTypeEditable()))
        return 2;
      if ((paramInt == 3) && (localIBusinessObjectEditen.isGroupEditable()))
        return 1;
    }
    return 0;
  }

  protected boolean a(IElement paramIElement, boolean paramBoolean)
  {
    if (b())
      return false;
    if ((paramIElement != null) && ((paramIElement instanceof IBusinessObject)))
    {
      IBusinessObject localIBusinessObject = (IBusinessObject)paramIElement;
      if ((localIBusinessObject.isVisible() != paramBoolean) && (!b()))
      {
        localIBusinessObject.setVisible(paramBoolean);
        K().setModified(true);
        return true;
      }
    }
    return false;
  }

  protected String[] E()
  {
    return I().a();
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
    if (paramInt == 1)
    {
      paramCCombo.setItems(E());
      paramCCombo.addKeyListener(new j(this, paramInt, paramCCombo));
    }
    super.a(paramCCombo, paramInt);
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if (b())
      return false;
    if (paramIElement == null)
    {
      if ((!K().canCreateEditen()) || (paramString.length() <= 0))
        break label586;
      try
      {
        K().initUndoable();
        String[] arrayOfString = paramString.split("\n");
        for (int i = 0; i < arrayOfString.length; i++)
        {
          String str = arrayOfString[i];
          if ((str == null) || (str.length() <= 0))
            continue;
          IBusinessObjectEditen localIBusinessObjectEditen2 = K().createSubEditen(str);
          localIBusinessObjectEditen2.setVisible(true);
          K().takeSnapshot();
          if ((localIBusinessObjectEditen2 == null) || (!localIBusinessObjectEditen2.canCreateSubFunction()) || (localIBusinessObjectEditen2.getJavaType().m()) || (localIBusinessObjectEditen2.getValueType().length() == 0) || (localIBusinessObjectEditen2.getValueType().equals("Object")))
            continue;
          a(localIBusinessObjectEditen2);
        }
        K().setModified(true);
        update();
        return true;
      }
      catch (com.flagleader.repository.d.p localp)
      {
        Logger.getLogger("flagleader").log(Level.SEVERE, paramString + localp.getMessage());
        return false;
      }
    }
    IBusinessObjectEditen localIBusinessObjectEditen1 = (IBusinessObjectEditen)paramIElement;
    if (paramInt == 0)
    {
      if ((localIBusinessObjectEditen1.isValueEditable()) && (!localIBusinessObjectEditen1.getValueName().equals(paramString)))
      {
        K().initUndoable();
        if ((localIBusinessObjectEditen1 instanceof MappingVariable))
          a(K().getMainPackage(), paramString, localIBusinessObjectEditen1.getValueName());
        localIBusinessObjectEditen1.setValueName(paramString);
        K().getEnvionment().registBusinessObject(localIBusinessObjectEditen1);
        K().setModified(true);
        K().takeSnapshot();
        return true;
      }
    }
    else if (paramInt == 1)
    {
      if ((localIBusinessObjectEditen1.isTypeEditable()) && (!localIBusinessObjectEditen1.getValueType().equals(paramString)))
      {
        K().initUndoable();
        localIBusinessObjectEditen1.changeValueType(paramString);
        K().getEnvionment().registBusinessObject(localIBusinessObjectEditen1);
        if (K().getMainPackage() != null)
          K().getMainPackage().changeElementType(localIBusinessObjectEditen1);
        K().setModified(true);
        K().takeSnapshot();
        return true;
      }
    }
    else if (paramInt == 2)
    {
      if (!localIBusinessObjectEditen1.getDisplayName().equals(paramString))
      {
        K().initUndoable();
        localIBusinessObjectEditen1.changeDisplayName(localIBusinessObjectEditen1.getDisplayName(), paramString);
        localIBusinessObjectEditen1.setDisplayName(paramString);
        K().setModified(true);
        K().takeSnapshot();
        return true;
      }
    }
    else if ((paramInt == 3) && (!localIBusinessObjectEditen1.getShowGroupName().equals(paramString)))
    {
      K().initUndoable();
      localIBusinessObjectEditen1.setShowGroupName(paramString);
      K().setModified(true);
      K().takeSnapshot();
      return true;
    }
    label586: return super.a(paramIElement, paramInt, paramString);
  }

  private void a(IRulePackage paramIRulePackage, String paramString1, String paramString2)
  {
    if (paramIRulePackage == null)
      return;
    IRuleRepository localIRuleRepository = a().getRulesManager().d();
    if (localIRuleRepository != null)
    {
      Iterator localIterator = localIRuleRepository.getAcceptElements(new k(this, paramIRulePackage, paramString2));
      ArrayList localArrayList = new ArrayList();
      while (localIterator.hasNext())
        localArrayList.add(localIterator.next());
      if (localArrayList.size() > 0)
        for (int i = 0; i < localArrayList.size(); i++)
        {
          Object localObject1 = localArrayList.get(i);
          if (!(localObject1 instanceof ExeRuleToken))
            continue;
          SelectRulePackageToken localSelectRulePackageToken = ((ExeRuleToken)localObject1).getRuleNameToken();
          List localList = localSelectRulePackageToken.getSelectedFields();
          Object localObject2;
          for (int j = 0; j < localList.size(); j++)
          {
            localObject2 = (PackageFieldGet)localList.get(j);
            if (!((PackageFieldGet)localObject2).getFuncName().equals(paramString2))
              continue;
            ((PackageFieldGet)localObject2).setFuncName(paramString1);
          }
          localList = localSelectRulePackageToken.getSelectedWheres();
          for (j = 0; j < localList.size(); j++)
          {
            localObject2 = (PackageFieldSet)localList.get(j);
            if (!((PackageFieldSet)localObject2).getFuncName().equals(paramString2))
              continue;
            ((PackageFieldSet)localObject2).setFuncName(paramString1);
          }
          localSelectRulePackageToken.getRoot().setModified(true);
        }
    }
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof IBusinessObjectEditen)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected String[] a(IElement paramIElement)
  {
    if ((paramIElement instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramIElement;
      return new String[] { localIBusinessObjectEditen.getValueName(), localIBusinessObjectEditen.getValueType(), localIBusinessObjectEditen.getDisplayName(), localIBusinessObjectEditen.getShowGroupName(), localIBusinessObjectEditen.getVarValue() };
    }
    return new String[] { paramIElement.getDisplayName() };
  }

  protected void a(Item paramItem, IElement paramIElement)
  {
    if (paramIElement == null)
      return;
    if ((paramIElement instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen1 = (IBusinessObjectEditen)paramIElement;
      super.a(paramItem, localIBusinessObjectEditen1.isVisible(), a(paramIElement));
      if ((localIBusinessObjectEditen1 instanceof IVariableObject))
        if (((IVariableObject)localIBusinessObjectEditen1).isLoged())
          a(paramItem, com.flagleader.builder.widget.h.j);
        else
          a(paramItem, null);
      paramItem.setData(localIBusinessObjectEditen1);
      if (localIBusinessObjectEditen1.hasSubEditen())
      {
        Iterator localIterator = localIBusinessObjectEditen1.getSubEditens();
        while (localIterator.hasNext())
        {
          IBusinessObjectEditen localIBusinessObjectEditen2 = (IBusinessObjectEditen)localIterator.next();
          if ((b()) && (!localIBusinessObjectEditen2.isVisible()))
            continue;
          Item localItem = d(paramItem);
          localItem.setData(localIBusinessObjectEditen2);
          a(localItem, localIBusinessObjectEditen2);
        }
      }
      localIBusinessObjectEditen1.setObjectEditor(new l(this, paramItem));
    }
    if (K().equals(paramIElement.getParent()))
      b(paramItem);
  }

  protected boolean e()
  {
    return true;
  }

  private void a(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    com.flagleader.builder.dialogs.a.g localg = new com.flagleader.builder.dialogs.a.g(this.b.getShell(), paramIBusinessObjectEditen.getCanCreateSubFunction());
    if ((localg.open() == 0) && (localg.a().size() > 0))
    {
      K().initUndoable();
      paramIBusinessObjectEditen.createSubFunction(localg.a());
      K().takeSnapshot();
    }
  }

  private void F()
  {
    com.flagleader.builder.dialogs.a.i locali = new com.flagleader.builder.dialogs.a.i(this.b.getShell(), J().a());
    if (locali.open() == 0)
    {
      List localList = locali.a();
      if (localList.size() > 0)
      {
        K().initUndoable();
        for (int i = 0; i < localList.size(); i++)
        {
          GlobalMethod localGlobalMethod = (GlobalMethod)localList.get(i);
          GlobalFunction localGlobalFunction = new GlobalFunction(localGlobalMethod.getFuncName(), localGlobalMethod.getReturnType(), J().b(localGlobalMethod), J().c(localGlobalMethod), J().a(localGlobalMethod), localGlobalMethod.getTypeName());
          localGlobalFunction.setVisible(true);
          K().addChildElement(localGlobalFunction);
        }
        K().setModified(true);
        K().takeSnapshot();
        update();
      }
    }
  }

  private void b(IBusinessObjectEditen paramIBusinessObjectEditen)
  {
    com.flagleader.builder.dialogs.a.i locali = new com.flagleader.builder.dialogs.a.i(this.b.getShell(), J().a(paramIBusinessObjectEditen.getJavaType()));
    if (locali.open() == 0)
    {
      List localList = locali.a();
      if (localList.size() > 0)
      {
        K().initUndoable();
        for (int i = 0; i < localList.size(); i++)
        {
          TypeMethod localTypeMethod = (TypeMethod)localList.get(i);
          SubTypeMethod localSubTypeMethod = new SubTypeMethod(localTypeMethod.getFuncName(), localTypeMethod.getReturnType(), "", J().b(localTypeMethod, paramIBusinessObjectEditen.getParams()), StringUtil.replace("$p", paramIBusinessObjectEditen.getDisplayName(), J().c(localTypeMethod, paramIBusinessObjectEditen.getParams())), J().a(localTypeMethod, paramIBusinessObjectEditen.getParams()));
          localSubTypeMethod.setVisible(true);
          paramIBusinessObjectEditen.addChildElement(localSubTypeMethod);
        }
        K().setModified(true);
        K().takeSnapshot();
        paramIBusinessObjectEditen.update();
      }
    }
  }

  private List a(List paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramList.size() + 1);
    localArrayList.addAll(paramList);
    localArrayList.add(new MethodParam(paramString, paramList.size()));
    return localArrayList;
  }

  public boolean canPaste()
  {
    if (b())
      return false;
    Object localObject1 = new Clipboard(Display.getCurrent()).getContents(com.flagleader.builder.widget.d.a());
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

  public boolean canRedo()
  {
    if (b())
      return false;
    return K().canRedo();
  }

  public boolean canUndo()
  {
    if (b())
      return false;
    return K().canUndo();
  }

  public void copy()
  {
    if (j() <= 0)
      return;
    IElement[] arrayOfIElement = k();
    if (arrayOfIElement.length == 1)
    {
      new Clipboard(Display.getCurrent()).setContents(new Object[] { arrayOfIElement[0] }, new Transfer[] { com.flagleader.builder.widget.d.a() });
      a().getMessageWindow().a(arrayOfIElement[0]);
    }
    else
    {
      ElementContainer localElementContainer = new ElementContainer();
      for (int i = 0; i < arrayOfIElement.length; i++)
      {
        if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof IBusinessObjectEditen)) || (((IBusinessObjectEditen)arrayOfIElement[i]).getParent() == null) || (!((IBusinessObjectEditen)arrayOfIElement[i]).getParent().equals(K())))
          continue;
        localElementContainer.addChildElement((IBusinessObjectEditen)arrayOfIElement[i]);
      }
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { com.flagleader.builder.widget.d.a() });
      a().getMessageWindow().a(localElementContainer);
    }
  }

  public void cut()
  {
    if (b())
      return;
    if (j() <= 0)
      return;
    ElementContainer localElementContainer = new ElementContainer();
    IElement[] arrayOfIElement = k();
    if (arrayOfIElement.length > 0)
    {
      K().initUndoable();
      for (int i = 0; i < arrayOfIElement.length; i++)
      {
        if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof IBusinessObjectEditen)) || (((IBusinessObjectEditen)arrayOfIElement[i]).getParent() == null) || (!((IBusinessObjectEditen)arrayOfIElement[i]).getParent().equals(K())))
          continue;
        localElementContainer.addChildElement((IBusinessObjectEditen)arrayOfIElement[i]);
        ((IBusinessObjectEditen)arrayOfIElement[i]).disposeAndUpdate();
      }
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localElementContainer }, new Transfer[] { com.flagleader.builder.widget.d.a() });
      K().setModified(true);
      K().takeSnapshot();
      K().updateViewer();
    }
    if ((!this.c.isLocked()) && (a().getConfigManager().E()))
      a().getRulesManager().c().a(K().getMainPackage());
  }

  public void delete()
  {
    if (b())
      return;
    if (j() <= 0)
      return;
    IElement[] arrayOfIElement = k();
    if (arrayOfIElement.length > 0)
    {
      K().initUndoable();
      for (int i = 0; i < arrayOfIElement.length; i++)
      {
        if ((arrayOfIElement[i] == null) || (!(arrayOfIElement[i] instanceof IBusinessObjectEditen)))
          continue;
        ((IBusinessObjectEditen)arrayOfIElement[i]).disposeAndUpdate();
      }
      K().setModified(true);
      K().takeSnapshot();
      K().updateViewer();
    }
    if ((!this.c.isLocked()) && (a().getConfigManager().E()))
      a().getRulesManager().c().a(K().getMainPackage());
  }

  public boolean paste()
  {
    if (b())
      return false;
    int i = -1;
    if (j() == 1)
      i = K().getElementPos(k()[0]);
    Object localObject = new Clipboard(Display.getCurrent()).getContents(com.flagleader.builder.widget.d.a());
    if ((localObject != null) && (((localObject instanceof IBusinessObjectEditen)) || ((localObject instanceof ElementContainer))))
    {
      if (K().pasteElement(((IElement)localObject).deepClone(), i))
        K().setModified(true);
      update();
      return true;
    }
    return false;
  }

  public boolean redo()
  {
    boolean bool = K().redo();
    if (bool)
      K().setModified(true);
    update();
    return bool;
  }

  public boolean undo()
  {
    boolean bool = K().undo();
    if (bool)
      K().setModified(true);
    update();
    return bool;
  }

  public void H()
  {
    if (j() == 1)
    {
      IElement localIElement = k()[0];
      if (((localIElement instanceof IBusinessObject)) && (K().getMainPackage() != null))
        a().getMessageWindow().a(K().getMainPackage().getAllElementSelect((IBusinessObject)localIElement));
    }
  }

  public com.flagleader.repository.lang.h I()
  {
    return K().getEnvionment().getTypeManager();
  }

  public com.flagleader.repository.lang.d J()
  {
    return K().getEnvionment().getMethodManager();
  }

  public IBusinessObjectContainer K()
  {
    return (IBusinessObjectContainer)this.c;
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
      localArrayList2.add(a(localRow.getCell(1)));
      localArrayList3.add(a(localRow.getCell(2)));
      localArrayList4.add(a(localRow.getCell(3)));
    }
    K().replaceVariables(localArrayList1, localArrayList2, localArrayList3, localArrayList4);
  }

  protected String a(Cell paramCell)
  {
    if (paramCell != null)
      switch (paramCell.getCellType())
      {
      case 4:
        return StringUtil.stringValue(paramCell.getBooleanCellValue());
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

  protected y G()
  {
    return new D(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.e
 * JD-Core Version:    0.6.0
 */