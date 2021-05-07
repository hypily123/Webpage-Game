/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.me.dao.EquipmentDAO;
import com.me.dao.DungeonDAO;
import com.me.dao.DungeonMonsterPairDAO;
import com.me.dao.InBattleDAO;
import com.me.dao.InventoryDAO;
import com.me.dao.MonsterDAO;
import com.me.dao.UserDAO;
import com.me.dao.UserEquipmentPairDAO;
import com.mycompany.pojo.Dungeon;
import com.mycompany.pojo.DungeonMonsterPair;
import com.mycompany.pojo.Equipment;
import com.mycompany.pojo.InBattle;
import com.mycompany.pojo.Inventory;
import com.mycompany.pojo.Monster;
import com.mycompany.pojo.User;
import com.mycompany.pojo.UserEquipmentPair;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jian Xiao
 */
@Controller
public class PlayerController {

    @RequestMapping(value = "/Player_Main.htm", method = RequestMethod.GET)
    public ModelAndView Player_Main_Get(HttpServletRequest request, HttpServletResponse response, EquipmentDAO equipmentDAO, UserEquipmentPairDAO userEquipmentPairDAO, InventoryDAO inventoryDAO) {
        User user = (User) request.getSession().getAttribute("user");
        try {
            Equipment weapon = equipmentDAO.searchEquipment(userEquipmentPairDAO.searchUserEquipmentPair(user.getUsername(), "weapon").getEquipmentID());
            request.setAttribute("weapon", weapon);
        } catch (Exception e) {
        }
        try {
            Equipment armor = equipmentDAO.searchEquipment(userEquipmentPairDAO.searchUserEquipmentPair(user.getUsername(), "armor").getEquipmentID());
            request.setAttribute("armor", armor);
        } catch (Exception e) {
        }
        try {
            Equipment boot = equipmentDAO.searchEquipment(userEquipmentPairDAO.searchUserEquipmentPair(user.getUsername(), "boot").getEquipmentID());
            request.setAttribute("boot", boot);
        } catch (Exception e) {
        }
        List<Inventory> inventory = inventoryDAO.getAllInventorys(user);
        if (inventory != null) {
            List<Equipment> weapons = new ArrayList<>();
            List<Equipment> armors = new ArrayList<>();
            List<Equipment> boots = new ArrayList<>();
            for (int i = 0; i < inventory.size(); i++) {
                Equipment e = equipmentDAO.searchEquipment(inventory.get(i).getEquipmentID());
                switch (e.getPart()) {
                    case "weapon":
                        weapons.add(e);
                        break;
                    case "armor":
                        armors.add(e);
                        break;
                    case "boot":
                        boots.add(e);
                        break;
                    default:
                        System.out.println("Equipment does not have a valid part attribute" + e.toString());
                }
            }
            request.setAttribute("weapons", weapons);
            request.setAttribute("armors", armors);
            request.setAttribute("boots", boots);
        }
        return new ModelAndView("Player_Main");
    }

    @RequestMapping(value = "/Player_Main.htm", method = RequestMethod.POST)
    public ModelAndView Player_Main(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, EquipmentDAO equipmentDAO, UserEquipmentPairDAO userEquipmentPairDAO, InventoryDAO inventoryDAO) {
        User user = (User) request.getSession().getAttribute("user");
        int vit = Integer.parseInt(request.getParameter("vit"));
        int pow = Integer.parseInt(request.getParameter("pow"));
        int str = Integer.parseInt(request.getParameter("str"));
        int intelligence = Integer.parseInt(request.getParameter("intelligence"));
        int dex = Integer.parseInt(request.getParameter("dex"));
        int lvl = user.getLvl();
        int points = lvl * 5 + 20 - vit - pow - str - intelligence - dex;
        if (points >= 0) {
            user.setVit(vit);
            user.setPow(pow);
            user.setStr(str);
            user.setIntelligence(intelligence);
            user.setDex(dex);
            user.setLvl(lvl);
            user.setPoints(points);
            userDAO.updateUser(user);
            request.getSession().setAttribute("user", user);
        } else {
            request.setAttribute("msg", "You spent more points than you have");
        }
        if (request.getParameter("weapon") != null) {
            userEquipmentPairDAO.updateUserEquipmentPair(user.getUsername(), Integer.parseInt(request.getParameter("weapon")), "weapon");
        }
        if (request.getParameter("armor") != null) {
            userEquipmentPairDAO.updateUserEquipmentPair(user.getUsername(), Integer.parseInt(request.getParameter("armor")), "armor");
        }
        if (request.getParameter("boot") != null) {
            userEquipmentPairDAO.updateUserEquipmentPair(user.getUsername(), Integer.parseInt(request.getParameter("boot")), "boot");
        }
        try {
            Equipment weapon = equipmentDAO.searchEquipment(userEquipmentPairDAO.searchUserEquipmentPair(user.getUsername(), "weapon").getEquipmentID());
            request.setAttribute("weapon", weapon);
        } catch (Exception e) {
        }
        try {
            Equipment armor = equipmentDAO.searchEquipment(userEquipmentPairDAO.searchUserEquipmentPair(user.getUsername(), "armor").getEquipmentID());
            request.setAttribute("armor", armor);
        } catch (Exception e) {
        }
        try {
            Equipment boot = equipmentDAO.searchEquipment(userEquipmentPairDAO.searchUserEquipmentPair(user.getUsername(), "boot").getEquipmentID());
            request.setAttribute("boot", boot);
        } catch (Exception e) {
        }
        List<Inventory> inventory = inventoryDAO.getAllInventorys(user);
        if (inventory != null) {
            List<Equipment> weapons = new ArrayList<>();
            List<Equipment> armors = new ArrayList<>();
            List<Equipment> boots = new ArrayList<>();
            for (int i = 0; i < inventory.size(); i++) {
                Equipment e = equipmentDAO.searchEquipment(inventory.get(i).getEquipmentID());
                switch (e.getPart()) {
                    case "weapon":
                        weapons.add(e);
                        break;
                    case "armor":
                        armors.add(e);
                        break;
                    case "boot":
                        boots.add(e);
                        break;
                    default:
                        System.out.println("Equipment does not have a valid part attribute" + e.toString());
                }
            }
            request.setAttribute("weapons", weapons);
            request.setAttribute("armors", armors);
            request.setAttribute("boots", boots);
            request.getSession().setAttribute("equipments", userEquipmentPairDAO.getAllUserEquipmentPair(user.getUsername()));
        }
        return new ModelAndView("Player_Main");
    }

    @RequestMapping(value = "/Player_Store.htm", method = RequestMethod.GET)
    public ModelAndView Player_Store_GET(HttpServletRequest request, HttpServletResponse response, InventoryDAO inventoryDAO, EquipmentDAO equipmentDAO) {
        User user = (User) request.getSession().getAttribute("user");
        List<Inventory> loi = inventoryDAO.getAllInventorys(user);
        List<Equipment> loe = new ArrayList<>();
        for (Inventory i : loi) {
            loe.add(equipmentDAO.searchEquipment(i.getEquipmentID()));
        }
        request.setAttribute("inventory", loe);
        request.setAttribute("equipments", equipmentDAO.getAllEquipments());
        return new ModelAndView("Player_Store");
    }

    @RequestMapping(value = "/Player_Store.htm", method = RequestMethod.POST)
    public ModelAndView Player_Store(HttpServletRequest request, HttpServletResponse response, InventoryDAO inventoryDAO, EquipmentDAO equipmentDAO, UserEquipmentPairDAO userEquipmentPairDAO) {
        User user = (User) request.getSession().getAttribute("user");
        int sum_buy = 0, sum_sell = 0, gold = user.getGold();
        int[] buy_id, sell_id;
        String msg = null;
        String[] buy = request.getParameterValues("buy");
        String[] sell = request.getParameterValues("sell");
        if (buy == null) {
            buy_id = new int[0];
        } else {
            buy_id = new int[buy.length];
        }
        if (sell == null) {
            sell_id = new int[0];
        } else {
            sell_id = new int[sell.length];
        }
        for (int i = 0; i < buy_id.length; i++) {
            String[] temp = buy[i].split(",");
            buy_id[i] = Integer.parseInt(temp[0]);
            sum_buy += Integer.parseInt(temp[1]);
        }
        for (int i = 0; i < sell_id.length; i++) {
            String[] temp = sell[i].split(",");
            sell_id[i] = Integer.parseInt(temp[0]);
            sum_sell += Integer.parseInt(temp[1]);
        }
        if (gold + sum_sell - sum_buy >= 0) {
            user.setGold(gold + sum_sell - sum_buy);
            for (int i : buy_id) {
                inventoryDAO.addInventory(user.getUsername(), i);
            }
            for (int i : sell_id) {
                inventoryDAO.deleteInventory(user.getUsername(), i);
            }
        } else {
            msg = "do not have sufficient gold";
        }
        List<UserEquipmentPair> lou = userEquipmentPairDAO.getAllUserEquipmentPair(user.getUsername());
        List<Inventory> loi = inventoryDAO.getAllInventorys(user);
        List<Integer> equipmentIDs = new ArrayList<>();
        for (Inventory i : loi) {
            equipmentIDs.add(i.getEquipmentID());
        }
        for (UserEquipmentPair uep : lou) {
            if (!equipmentIDs.contains(uep.getEquipmentID())) {
                userEquipmentPairDAO.deleteUserEquipmentPair(uep);
            }
        }
        List<Equipment> loe = new ArrayList<>();
        for (Inventory i : loi) {
            loe.add(equipmentDAO.searchEquipment(i.getEquipmentID()));
        }
        request.setAttribute("inventory", loe);
        request.setAttribute("equipments", equipmentDAO.getAllEquipments());
        if (msg == null) {
            return new ModelAndView("Player_Store");
        }
        return new ModelAndView("Player_Store", "msg", msg);
    }

    @RequestMapping(value = "/Player_Dungeon.htm", method = RequestMethod.POST)
    public ModelAndView Player_Dungeon(HttpServletRequest request, HttpServletResponse response, DungeonDAO dungeonDAO) {
        request.setAttribute("dungeons", dungeonDAO.getAllDungeons((User) request.getSession().getAttribute("user")));
        return new ModelAndView("Player_Dungeon");
    }

    @RequestMapping(value = "/Player_Enter_Dungeon.htm", method = RequestMethod.POST)
    public ModelAndView Player_To_Dungeon(HttpServletRequest request, HttpServletResponse response, MonsterDAO monsterDAO,
            DungeonDAO dungeonDAO, DungeonMonsterPairDAO dungeonMonsterPairDAO, EquipmentDAO equipmentDAO, InBattleDAO inBattleDAO) {
        User user = (User) request.getSession().getAttribute("user");
        if (inBattleDAO.searchInBattle(user.getUsername()) != null) {
            InBattle ib = inBattleDAO.searchInBattle(user.getUsername());
            if (ib.getCurHP() == 0) {
                inBattleDAO.deleteInBattle(ib);
                return new ModelAndView("Player_Main");
            }
            Dungeon d = dungeonDAO.searchDungeon(ib.getDungeonID());
            List<DungeonMonsterPair> pairs = dungeonMonsterPairDAO.searchDungeonMonsterPair(d.getId(), ib.getWave());
            while (pairs.isEmpty() && ib.getWave() < d.getWaves()) {
                ib.setWave(ib.getWave() + 1);
                inBattleDAO.updateInBattle(ib);
                pairs = dungeonMonsterPairDAO.searchDungeonMonsterPair(d.getId(), ib.getWave());
            }
            if (pairs.isEmpty() && ib.getWave() == d.getWaves()) {
                inBattleDAO.deleteInBattle(ib);
                return new ModelAndView("Player_Main");
            }
            Monster[] ms = new Monster[pairs.size()];
            for (int i = 0; i < ms.length; i++) {
                ms[i] = monsterDAO.searchMonster(pairs.get(i).getMonsterID());
            }
            request.setAttribute("monsters", ms);
            request.setAttribute("curHP", ib.getCurHP());
            request.setAttribute("curWave", ib.getWave());
            return new ModelAndView("Player_Battle");
        }
        System.out.println(request.getParameter("enter dungeon"));
        Dungeon dungeon = new Dungeon(request.getParameter("dungeon"));
        try {
            inBattleDAO.addInBattle(user.getUsername(), user.getVit() * 10, dungeon.getId());
            List<DungeonMonsterPair> pairs = dungeonMonsterPairDAO.searchDungeonMonsterPair(dungeon.getId(), 1);
            Monster[] ms = new Monster[pairs.size()];
            for (int i = 0; i < ms.length; i++) {
                ms[i] = monsterDAO.searchMonster(pairs.get(i).getMonsterID());
            }
            request.setAttribute("monsters", ms);
            request.setAttribute("curHP", user.getVit() * 10);
            request.setAttribute("curWave", 1);
            return new ModelAndView("Player_Battle");
        } catch (Exception e) {
            return new ModelAndView("Player_Dungeon", "msg", "Unable to enter the dungeon");
        }
    }

    @RequestMapping(value = "/Player_InBattle.htm", method = RequestMethod.POST)
    public ModelAndView Player_InBattle(HttpServletRequest request, HttpServletResponse response, MonsterDAO monsterDAO,
            DungeonDAO dungeonDAO, DungeonMonsterPairDAO dungeonMonsterPairDAO, EquipmentDAO equipmentDAO, UserDAO userDAO, InBattleDAO inBattleDAO) {
        User user = (User) request.getSession().getAttribute("user");
        try {
            user.setGold(user.getGold() + Integer.parseInt(request.getParameter("gold")));
            int exp = user.getExp() + Integer.parseInt(request.getParameter("exp"));
            if (exp >= 100) {
                int temp = exp / 100;
                exp = exp % 100;
                user.setLvl(user.getLvl() + temp);
                user.setExp(exp);
                user.setPoints(user.getPoints() + temp * 5);
            } else {
                user.setExp(exp);
            }
            userDAO.updateUser(user);
            request.getSession().setAttribute("user", user);
        } catch (Exception e) {

        }
        InBattle ib = null;
        try {
            ib = inBattleDAO.searchInBattle(user.getUsername());
        } catch (Exception e) {

        }
        if (ib == null) {
            return new ModelAndView("Player_End_Battle");
        }
        if (ib.getCurHP() == 0) {
            inBattleDAO.deleteInBattle(ib);
            return new ModelAndView("Player_End_Battle");
        }
        Dungeon d = dungeonDAO.searchDungeon(ib.getDungeonID());
        if (ib.getWave() >= d.getWaves()) {
            inBattleDAO.deleteInBattle(ib);
            return new ModelAndView("Player_End_Battle");
        } else {
            ib.setWave(ib.getWave() + 1);
            inBattleDAO.updateInBattle(ib);
            try {
                List<DungeonMonsterPair> pairs = dungeonMonsterPairDAO.searchDungeonMonsterPair(d.getId(), ib.getWave());
                while (pairs.isEmpty() && ib.getWave() < d.getWaves()) {
                    ib.setWave(ib.getWave() + 1);
                    inBattleDAO.updateInBattle(ib);
                    pairs = dungeonMonsterPairDAO.searchDungeonMonsterPair(d.getId(), ib.getWave());
                }
                if (pairs.isEmpty() && ib.getWave() == d.getWaves()) {
                    inBattleDAO.deleteInBattle(ib);
                    return new ModelAndView("Player_End_Battle");
                }
                Monster[] ms = new Monster[pairs.size()];
                for (int i = 0; i < ms.length; i++) {
                    ms[i] = monsterDAO.searchMonster(pairs.get(i).getMonsterID());
                }
                request.setAttribute("monsters", ms);
                request.setAttribute("curHP", ib.getCurHP());
                request.setAttribute("curWave", ib.getWave());
                return new ModelAndView("Player_Battle");
            } catch (Exception e) {
                return new ModelAndView("Player_Dungeon", "msg", "Unable to enter the dungeon");
            }
        }
    }
}
